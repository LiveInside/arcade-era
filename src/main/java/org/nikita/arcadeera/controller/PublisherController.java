package org.nikita.arcadeera.controller;

import org.nikita.arcadeera.dto.request.RequestPublisherDTO;
import org.nikita.arcadeera.dto.response.PublisherDTO;
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
@RequestMapping("/publishers")
public interface PublisherController {
    @GetMapping("/{id}")
    ResponseEntity<PublisherDTO> getPublisherById(@PathVariable Integer id);

    @GetMapping
    ResponseEntity<List<PublisherDTO>> getAllPublisher();

    @PostMapping
    ResponseEntity<PublisherDTO> createPublisher(@RequestBody PublisherDTO publisherDTO);

    @PatchMapping("/{id}")
    ResponseEntity<PublisherDTO> updatePublisher(@RequestBody RequestPublisherDTO publisherDTO, @PathVariable Integer id);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteUser(@PathVariable Integer id);
}
