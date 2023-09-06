package org.nikita.arcadeera.controller;

import org.nikita.arcadeera.dto.GameDTO;
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
@RequestMapping("/game")
public interface GameController {
    @GetMapping("/{id}")
    ResponseEntity<GameDTO> getGameById(@PathVariable Integer id);

    @GetMapping
    ResponseEntity<List<GameDTO>> getAllGames();

    @PostMapping
    ResponseEntity<Void> createUser(@RequestBody GameDTO gameDTO);

    @PutMapping("/{id}")
    ResponseEntity<Void> updateUser(@PathVariable Integer id, GameDTO gameDTO);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteUser(@PathVariable Integer id);
}
