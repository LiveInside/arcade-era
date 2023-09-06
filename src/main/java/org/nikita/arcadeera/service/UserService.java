package org.nikita.arcadeera.service;

import org.nikita.arcadeera.dto.UserDTO;

import java.util.List;

public interface UserService {
    void createUser(UserDTO userDTO);
    UserDTO getUserByID(Integer id);
    List<UserDTO> getAllUsers();
    void updateUser(Integer id, UserDTO userDTO);
    void deleteUser(Integer id);
}
