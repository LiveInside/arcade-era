package org.nikita.arcadeera.controller.impl;

import lombok.AllArgsConstructor;
import org.nikita.arcadeera.controller.UserController;
import org.nikita.arcadeera.dto.UserDTO;
import org.nikita.arcadeera.service.UserService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserControllerImpl implements UserController {
    private final UserService userService;

    @Override
    public UserDTO getUserById(Integer id) {
        return userService.getUserByID(id);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @Override
    public void createOrUpdateUser(UserDTO userDTO) {
        userService.createOrUpdateUser(userDTO);
    }


    @Override
    public void deleteUser(Integer id) {
        userService.deleteUser(id);
    }
}
