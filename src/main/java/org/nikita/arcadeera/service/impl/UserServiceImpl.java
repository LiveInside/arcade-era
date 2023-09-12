package org.nikita.arcadeera.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.nikita.arcadeera.converter.user.UserConverterToDTO;
import org.nikita.arcadeera.converter.user.UserConverterToEntity;
import org.nikita.arcadeera.dto.request.RequestUserDTO;
import org.nikita.arcadeera.dto.response.UserDTO;
import org.nikita.arcadeera.entity.User;
import org.nikita.arcadeera.exception.EmptyParamException;
import org.nikita.arcadeera.exception.ResourceNotFoundException;
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
    private final UserConverterToDTO userConverterToDTO;
    private final UserConverterToEntity userConverterToEntity;

    @Override
    public UserDTO getUserByID(Integer id) {
        User user = userRepository.findById(id).orElse(null);
        return userConverterToDTO.convert(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        if (CollectionUtils.isEmpty(users)) {
            throw new ResourceNotFoundException("Таблица user пустая");
        }

        return users.stream()
                .map(userConverterToDTO::convert)
                .toList();
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        if (userDTO.getAge() == null)
            throw new EmptyParamException("Поле Age обязательно к заполнению");

        User user = userConverterToEntity.convert(userDTO);
        userRepository.save(user);
        return userConverterToDTO.convert(user);
    }

    @Override
    public UserDTO updateUser(RequestUserDTO userDTO, Integer id) {
        User user = userRepository.findById(id).orElse(null);
        UserDTO updatedUserDTO = userConverterToDTO.convert(user);

        if (userDTO.getName() == null || userDTO.getName().isEmpty()) {
            throw new EmptyParamException("Поле \"Имя\" обязательно для заполнения");
        }
        if (userDTO.getRegion() == null || userDTO.getRegion().isEmpty()) {
            throw new EmptyParamException("Поле \"Регион\" обязательно для заполнения");
        }
        if (userDTO.getBalance() != null) {
            updatedUserDTO.setBalance(userDTO.getBalance());
        }
        updatedUserDTO.setRegion(userDTO.getRegion())
                .setName(userDTO.getName());

        User updatedUser = userConverterToEntity.convert(updatedUserDTO);
        userRepository.save(updatedUser);
        return updatedUserDTO;
    }

    @Override
    public void deleteUser(Integer id) {
        if (Objects.isNull(id))
            throw new EmptyParamException("Пустой параметр");
        userRepository.deleteById(id);
    }
}
