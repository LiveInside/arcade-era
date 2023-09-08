package org.nikita.arcadeera.service;

import org.nikita.arcadeera.dto.PublisherDTO;

import java.util.List;

public interface PublisherService {
    PublisherDTO getPublisherById(Integer id);

    List<PublisherDTO> getAllPublisher();

    void createOrUpdatePublisher(PublisherDTO publisherDTO);

    void deletePublisher(Integer id);

}
