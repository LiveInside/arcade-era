package org.nikita.arcadeera.service;

import org.nikita.arcadeera.dto.request.PublisherCreateRequest;
import org.nikita.arcadeera.dto.request.PublisherUpdateRequest;
import org.nikita.arcadeera.dto.response.PublisherDTO;
import org.nikita.arcadeera.exception.NotUpdated;

import java.util.List;

public interface PublisherService {
    PublisherDTO get(Integer id);

    List<PublisherDTO> getAll();

    PublisherDTO create(PublisherCreateRequest publisherCreateRequest);

    PublisherDTO update(PublisherUpdateRequest publisherUpdateRequest, Integer id) throws NotUpdated;

    void delete(Integer id);

}
