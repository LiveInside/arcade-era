package org.nikita.arcadeera.service;

import org.nikita.arcadeera.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO getUserByID(Integer id);

    List<UserDTO> getAllUsers();

    void createOrUpdateUser(UserDTO userDTO);

    void deleteUser(Integer id);
}
