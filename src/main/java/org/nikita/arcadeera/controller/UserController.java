package org.nikita.arcadeera.controller;

import org.nikita.arcadeera.dto.request.UserCreateRequest;
import org.nikita.arcadeera.dto.request.UserUpdateRequest;
import org.nikita.arcadeera.dto.response.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public interface UserController {
    @GetMapping("/{id}")
    ResponseEntity<UserDTO> getUserById(@PathVariable Integer id);

    @GetMapping
    ResponseEntity<List<UserDTO>> getAllUsers();

    @PostMapping
    ResponseEntity<UserDTO> createUser(@RequestBody UserCreateRequest userCreateRequest);

    @PutMapping("/{id}")
    ResponseEntity<UserDTO> updateUser(@RequestBody UserUpdateRequest userUpdateRequest, @PathVariable Integer id);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteUser(@PathVariable Integer id);
}
