package org.nikita.arcadeera.service;

import org.nikita.arcadeera.dto.request.RequestPublisherDTO;
import org.nikita.arcadeera.dto.response.PublisherDTO;

import java.util.List;

public interface PublisherService {
    PublisherDTO getPublisherById(Integer id);

    List<PublisherDTO> getAllPublisher();

    PublisherDTO createPublisher(PublisherDTO publisherDTO);

    PublisherDTO updatePublisher(RequestPublisherDTO publisherDTO, Integer id);

    void deletePublisher(Integer id);

}
