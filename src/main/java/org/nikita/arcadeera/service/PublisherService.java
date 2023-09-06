package org.nikita.arcadeera.service;

import org.nikita.arcadeera.dto.PublisherDTO;
import org.nikita.arcadeera.entity.Publisher;

import java.util.List;

public interface PublisherService {
    void createPublisher(PublisherDTO publisherDTO);
    PublisherDTO getPublisherById(Integer id);
    List<PublisherDTO> getAllPublisher();
    void updatePublisher(Integer id, PublisherDTO publisherDTO);
    void deletePublisher(Integer id);
}
