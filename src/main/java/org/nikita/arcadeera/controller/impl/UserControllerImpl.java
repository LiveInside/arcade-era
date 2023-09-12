package org.nikita.arcadeera.controller.impl;

import lombok.AllArgsConstructor;
import org.nikita.arcadeera.controller.UserController;
import org.nikita.arcadeera.dto.request.UserCreateRequest;
import org.nikita.arcadeera.dto.request.UserUpdateRequest;
import org.nikita.arcadeera.dto.response.UserDTO;
import org.nikita.arcadeera.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserControllerImpl implements UserController {
    private final UserService userService;

    @Override
    public ResponseEntity<UserDTO> getUserById(Integer id) {
        return ResponseEntity.ok().body(userService.getUserByID(id));
    }

    @Override
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return ResponseEntity.ok().body(userService.getAllUsers());
    }

    @Override
    public ResponseEntity<UserDTO> createUser(UserCreateRequest userCreateRequest) {
        return ResponseEntity.ok().body(userService.createUser(userCreateRequest));
    }

    @Override
    public ResponseEntity<UserDTO> updateUser(UserUpdateRequest userUpdateRequest, Integer id) {
        return ResponseEntity.ok().body(userService.updateUser(userUpdateRequest, id));
    }

    @Override
    public ResponseEntity<Void> deleteUser(Integer id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
