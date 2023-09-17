package org.nikita.arcadeera.service;

import org.nikita.arcadeera.dto.request.UserCreateRequest;
import org.nikita.arcadeera.dto.request.UserUpdateRequest;
import org.nikita.arcadeera.dto.response.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO get(Integer id);

    List<UserDTO> getAll();

    UserDTO create(UserCreateRequest userCreateRequest);

    UserDTO update(UserUpdateRequest userUpdateRequest, Integer id);

    void delete(Integer id);
}
