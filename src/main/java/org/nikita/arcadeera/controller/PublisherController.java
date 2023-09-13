package org.nikita.arcadeera.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.nikita.arcadeera.dto.request.PublisherCreateRequest;
import org.nikita.arcadeera.dto.request.PublisherUpdateRequest;
import org.nikita.arcadeera.dto.response.PublisherDTO;
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
@RequestMapping("/publishers")
public interface PublisherController {
    @GetMapping("/{id}")
    ResponseEntity<PublisherDTO> getPublisherById(@PathVariable @Min(value = 1, message = "Не может быть меньше 1") Integer id);

    @GetMapping
    ResponseEntity<List<PublisherDTO>> getAllPublisher();

    @PostMapping
    ResponseEntity<PublisherDTO> createPublisher(@Valid @RequestBody PublisherCreateRequest publisherCreateRequest);

    @PutMapping("/{id}")
    ResponseEntity<PublisherDTO> updatePublisher(@Valid @RequestBody PublisherUpdateRequest publisherUpdateRequest, @PathVariable Integer id);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteUser(@PathVariable Integer id);
}
