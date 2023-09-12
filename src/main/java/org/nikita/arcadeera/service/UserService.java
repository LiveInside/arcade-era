package org.nikita.arcadeera.service;

import org.nikita.arcadeera.dto.request.UserCreateRequest;
import org.nikita.arcadeera.dto.request.UserUpdateRequest;
import org.nikita.arcadeera.dto.response.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO getUserByID(Integer id);

    List<UserDTO> getAllUsers();

    UserDTO createUser(UserCreateRequest userCreateRequest);

    UserDTO updateUser(UserUpdateRequest userUpdateRequest, Integer id);

    void deleteUser(Integer id);
}
