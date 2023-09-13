package org.nikita.arcadeera.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
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
    ResponseEntity<UserDTO> getUserById(@PathVariable @Min(value = 1, message = "Не может быть меньше 1") Integer id);

    @GetMapping
    ResponseEntity<List<UserDTO>> getAllUsers();

    @PostMapping
    ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserCreateRequest userCreateRequest);

    @PutMapping("/{id}")
    ResponseEntity<UserDTO> updateUser(@Valid @RequestBody UserUpdateRequest userUpdateRequest, @PathVariable Integer id);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteUser(@PathVariable Integer id);
}
