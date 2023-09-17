package org.nikita.arcadeera.service.impl;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.nikita.arcadeera.checks.CheckNull;
import org.nikita.arcadeera.converter.Converter;
import org.nikita.arcadeera.dto.request.UserCreateRequest;
import org.nikita.arcadeera.dto.request.UserUpdateRequest;
import org.nikita.arcadeera.dto.response.UserDTO;
import org.nikita.arcadeera.entity.User;
import org.nikita.arcadeera.repository.UserRepository;
import org.nikita.arcadeera.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Log4j2
@AllArgsConstructor
@Validated
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final Converter<User, UserDTO> userConverterToDTO;
    private final Converter<UserDTO, User> userConverterToEntity;
    private final Converter<UserCreateRequest, User> userCreateConverterToEntity;
    private final CheckNull<User> checkNull;

    @Override
    public @NotNull(message = "Пользователь не найден") UserDTO get(Integer id) {
        User user = userRepository.findById(id).orElse(null);

        return userConverterToDTO.convert(user);
    }

    @Override
    public List<UserDTO> getAll() {
        List<User> users = userRepository.findAll();

        return users.stream()
                .map(userConverterToDTO::convert)
                .toList();
    }

    @Override
    public UserDTO create(UserCreateRequest userCreateRequest) {
        User user = userCreateConverterToEntity.convert(userCreateRequest);
        userRepository.save(user);

        return userConverterToDTO.convert(user);
    }

    @Override
    public @NotNull(message = "Пользователь не найден") UserDTO update(UserUpdateRequest userUpdateRequest, Integer id) {
        User user = userRepository.findById(id).orElse(null);
        checkNull.checkForNull(user);
        UserDTO updatedUserDTO = userConverterToDTO.convert(user);

        updatedUserDTO.setBalance(userUpdateRequest.getBalance())
                .setRegion(userUpdateRequest.getRegion())
                .setName(userUpdateRequest.getName());

        User updatedUser = userConverterToEntity.convert(updatedUserDTO);
        userRepository.save(updatedUser);

        return updatedUserDTO;
    }

    @Override
    public void delete(Integer id) {
        userRepository.deleteById(id);
    }
}
