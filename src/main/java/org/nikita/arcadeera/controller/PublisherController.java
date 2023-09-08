package org.nikita.arcadeera.controller;

import org.nikita.arcadeera.dto.PublisherDTO;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/publisher")
public interface PublisherController {
    @GetMapping("/{id}")
    PublisherDTO getPublisherById(@PathVariable Integer id);

    @GetMapping
    List<PublisherDTO> getAllPublisher();

    @PostMapping
    void createOrUpdatePublisher(@RequestBody PublisherDTO publisherDTO);

    @DeleteMapping
    void deleteUser(@RequestParam Integer id);
}
