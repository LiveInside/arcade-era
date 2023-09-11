package org.nikita.arcadeera.service;

import org.nikita.arcadeera.dto.request.RequestUserDTO;
import org.nikita.arcadeera.dto.response.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO getUserByID(Integer id);

    List<UserDTO> getAllUsers();

    UserDTO createUser(UserDTO userDTO);

    UserDTO updateUser(RequestUserDTO userDTO, Integer id);

    void deleteUser(Integer id);
}
