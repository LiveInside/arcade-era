package org.nikita.arcadeera.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.nikita.arcadeera.converter.UserConverter;
import org.nikita.arcadeera.dto.UserDTO;
import org.nikita.arcadeera.entity.User;
import org.nikita.arcadeera.exception.EmptyParam;
import org.nikita.arcadeera.repository.UserRepository;
import org.nikita.arcadeera.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
@Log4j2
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserConverter userConverter;

    @Override
    public UserDTO getUserByID(Integer id) {
        User user = userRepository.findById(id).orElse(null);
        if (Objects.isNull(user)) {
            log.info("User не найден");
            return null;
        }

        return userConverter.toDTO(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        if (CollectionUtils.isEmpty(users)) {
            log.info("Таблица games пустая");
            return Collections.emptyList();
        }

        return users.stream()
                .map(userConverter::toDTO)
                .toList();
    }

    @Override
    public void createOrUpdateUser(UserDTO userDTO) {
        if (Objects.isNull(userDTO))
            throw new EmptyParam("Пустой параметр");
        User user = userConverter.toEntity(userDTO);
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Integer id) {
        if (Objects.isNull(id))
            throw new EmptyParam("Пустой параметр");
        userRepository.deleteById(id);
    }
}
