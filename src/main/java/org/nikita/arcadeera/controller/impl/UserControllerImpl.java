package org.nikita.arcadeera.controller.impl;

import lombok.AllArgsConstructor;
import org.nikita.arcadeera.controller.UserController;
import org.nikita.arcadeera.dto.request.UserCreateRequest;
import org.nikita.arcadeera.dto.request.UserUpdateRequest;
import org.nikita.arcadeera.dto.response.UserDTO;
import org.nikita.arcadeera.exception.NotUpdated;
import org.nikita.arcadeera.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserControllerImpl implements UserController {
    private final UserService userService;

    @Override
    public ResponseEntity<UserDTO> get(Integer id) {
        return ResponseEntity.ok().body(userService.get(id));
    }

    @Override
    public ResponseEntity<List<UserDTO>> getAll() {
        return ResponseEntity.ok().body(userService.getAll());
    }

    @Override
    public ResponseEntity<UserDTO> create(UserCreateRequest userCreateRequest) {
        return ResponseEntity.ok().body(userService.create(userCreateRequest));
    }

    @Override
    public ResponseEntity<UserDTO> update(UserUpdateRequest userUpdateRequest, Integer id) throws NotUpdated {
        return ResponseEntity.ok().body(userService.update(userUpdateRequest, id));
    }

    @Override
    public ResponseEntity<Void> delete(Integer id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
