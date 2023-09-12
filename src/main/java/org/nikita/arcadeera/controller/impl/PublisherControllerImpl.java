package org.nikita.arcadeera.controller.impl;

import lombok.AllArgsConstructor;
import org.nikita.arcadeera.controller.PublisherController;
import org.nikita.arcadeera.dto.request.PublisherCreateRequest;
import org.nikita.arcadeera.dto.request.PublisherUpdateRequest;
import org.nikita.arcadeera.dto.response.PublisherDTO;
import org.nikita.arcadeera.service.PublisherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class PublisherControllerImpl implements PublisherController {
    private final PublisherService publisherService;

    @Override
    public ResponseEntity<PublisherDTO> getPublisherById(Integer id) {
        return ResponseEntity.ok().body(publisherService.getPublisherById(id));
    }

    @Override
    public ResponseEntity<List<PublisherDTO>> getAllPublisher() {
        return ResponseEntity.ok().body(publisherService.getAllPublisher());
    }

    @Override
    public ResponseEntity<PublisherDTO> createPublisher(PublisherCreateRequest publisherCreateRequest) {
        return ResponseEntity.ok().body(publisherService.createPublisher(publisherCreateRequest));
    }

    @Override
    public ResponseEntity<PublisherDTO> updatePublisher(PublisherUpdateRequest publisherUpdateRequest, Integer id) {
        return ResponseEntity.ok().body(publisherService.updatePublisher(publisherUpdateRequest, id));
    }

    @Override
    public ResponseEntity<Void> deleteUser(Integer id) {
        publisherService.deletePublisher(id);
        return ResponseEntity.noContent().build();
    }
}
