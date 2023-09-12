package org.nikita.arcadeera.service;

import org.nikita.arcadeera.dto.request.PublisherCreateRequest;
import org.nikita.arcadeera.dto.request.PublisherUpdateRequest;
import org.nikita.arcadeera.dto.response.PublisherDTO;

import java.util.List;

public interface PublisherService {
    PublisherDTO getPublisherById(Integer id);

    List<PublisherDTO> getAllPublisher();

    PublisherDTO createPublisher(PublisherCreateRequest publisherCreateRequest);

    PublisherDTO updatePublisher(PublisherUpdateRequest publisherUpdateRequest, Integer id);

    void deletePublisher(Integer id);

}
