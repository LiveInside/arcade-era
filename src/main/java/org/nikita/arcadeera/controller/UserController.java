package org.nikita.arcadeera.controller;

import org.nikita.arcadeera.dto.UserDTO;
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
@RequestMapping("/user")
public interface UserController {
    @GetMapping("/{id}")
    ResponseEntity<UserDTO> getUserById(@PathVariable Integer id);

    @GetMapping
    ResponseEntity<List<UserDTO>> getAllUsers();

    @PostMapping
    ResponseEntity<Void> createUser(@RequestBody UserDTO userDTO);

    @PutMapping("/{id}")
    ResponseEntity<Void> updateUser(@PathVariable Integer id, UserDTO userDTO);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteUser(@PathVariable Integer id);
}
