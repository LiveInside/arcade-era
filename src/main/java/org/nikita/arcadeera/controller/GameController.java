package org.nikita.arcadeera.controller;

import org.nikita.arcadeera.dto.request.RequestGameDTO;
import org.nikita.arcadeera.dto.response.GameDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/games")

public interface GameController {
    @GetMapping("/{id}")
    ResponseEntity<GameDTO> getGameById(@PathVariable Integer id);

    @GetMapping
    ResponseEntity<List<GameDTO>> getAllGames();

    @PostMapping
    ResponseEntity<GameDTO> createGame(@RequestBody GameDTO gameDTO);

    @PatchMapping("/{id}")
    ResponseEntity<GameDTO> updateGame(@RequestBody RequestGameDTO gameDTO, @PathVariable Integer id);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteGame(@PathVariable Integer id);
}