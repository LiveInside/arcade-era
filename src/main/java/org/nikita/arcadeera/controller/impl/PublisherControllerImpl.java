package org.nikita.arcadeera.controller.impl;

import lombok.AllArgsConstructor;
import org.nikita.arcadeera.controller.PublisherController;
import org.nikita.arcadeera.dto.request.PublisherCreateRequest;
import org.nikita.arcadeera.dto.request.PublisherUpdateRequest;
import org.nikita.arcadeera.dto.response.PublisherDTO;
import org.nikita.arcadeera.exception.NotUpdated;
import org.nikita.arcadeera.service.PublisherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class PublisherControllerImpl implements PublisherController {
    private final PublisherService publisherService;

    @Override
    public ResponseEntity<PublisherDTO> get(Integer id) {
        return ResponseEntity.ok().body(publisherService.get(id));
    }

    @Override
    public ResponseEntity<List<PublisherDTO>> getAll() {
        return ResponseEntity.ok().body(publisherService.getAll());
    }

    @Override
    public ResponseEntity<PublisherDTO> create(PublisherCreateRequest publisherCreateRequest) {
        return ResponseEntity.ok().body(publisherService.create(publisherCreateRequest));
    }

    @Override
    public ResponseEntity<PublisherDTO> update(PublisherUpdateRequest publisherUpdateRequest, Integer id) throws NotUpdated {
        return ResponseEntity.ok().body(publisherService.update(publisherUpdateRequest, id));
    }

    @Override
    public ResponseEntity<Void> delete(Integer id) {
        publisherService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
