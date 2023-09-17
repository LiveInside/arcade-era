package org.nikita.arcadeera.service;

import org.nikita.arcadeera.dto.request.PublisherCreateRequest;
import org.nikita.arcadeera.dto.request.PublisherUpdateRequest;
import org.nikita.arcadeera.dto.response.PublisherDTO;

import java.util.List;

public interface PublisherService {
    PublisherDTO get(Integer id);

    List<PublisherDTO> getAll();

    PublisherDTO create(PublisherCreateRequest publisherCreateRequest);

    PublisherDTO update(PublisherUpdateRequest publisherUpdateRequest, Integer id);

    void delete(Integer id);

}
