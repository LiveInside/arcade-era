package org.nikita.arcadeera.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.nikita.arcadeera.converter.Converter;
import org.nikita.arcadeera.dto.request.UserCreateRequest;
import org.nikita.arcadeera.dto.request.UserUpdateRequest;
import org.nikita.arcadeera.dto.response.UserDTO;
import org.nikita.arcadeera.entity.User;
import org.nikita.arcadeera.exception.EmptyParamException;
import org.nikita.arcadeera.exception.ResourceNotFoundException;
import org.nikita.arcadeera.repository.UserRepository;
import org.nikita.arcadeera.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
@Log4j2
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final Converter<User, UserDTO> userConverterToDTO;
    private final Converter<UserDTO, User> userConverterToEntity;
    private final Converter<UserCreateRequest, User> userCreateConverterToEntity;

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
    public UserDTO createUser(UserCreateRequest userCreateRequest) {
        if (userCreateRequest.getAge() == null)
            throw new EmptyParamException("Поле Age обязательно к заполнению");

        User user = userCreateConverterToEntity.convert(userCreateRequest);
        userRepository.save(user);
        return userConverterToDTO.convert(user);
    }

    @Override
    public UserDTO updateUser(UserUpdateRequest userUpdateRequest, Integer id) {
        User user = userRepository.findById(id).orElse(null);
        UserDTO updatedUserDTO = userConverterToDTO.convert(user);

        if (userUpdateRequest.getName() == null || userUpdateRequest.getName().isEmpty()) {
            throw new EmptyParamException("Поле \"Имя\" обязательно для заполнения");
        }
        if (userUpdateRequest.getRegion() == null || userUpdateRequest.getRegion().isEmpty()) {
            throw new EmptyParamException("Поле \"Регион\" обязательно для заполнения");
        }
        if (userUpdateRequest.getBalance() != null) {
            updatedUserDTO.setBalance(userUpdateRequest.getBalance());
        }
        updatedUserDTO.setRegion(userUpdateRequest.getRegion())
                .setName(userUpdateRequest.getName());

        User updatedUser = userConverterToEntity.convert(updatedUserDTO);
        userRepository.save(updatedUser);
        return updatedUserDTO;
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}
