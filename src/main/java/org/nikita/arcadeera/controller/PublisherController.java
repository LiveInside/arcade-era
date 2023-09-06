package org.nikita.arcadeera.controller;

import org.nikita.arcadeera.dto.PublisherDTO;
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
@RequestMapping("/publisher")
public interface PublisherController {
    @GetMapping("/{id}")
    ResponseEntity<PublisherDTO> getPublisherById(@PathVariable Integer id);

    @GetMapping
    ResponseEntity<List<PublisherDTO>> getAllPublisher();

    @PostMapping
    ResponseEntity<Void> createPublisher(@RequestBody PublisherDTO publisherDTO);

    @PutMapping("/{id}")
    ResponseEntity<Void> updateUser(@PathVariable Integer id, PublisherDTO publisherDTO);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteUser(@PathVariable Integer id);
}
