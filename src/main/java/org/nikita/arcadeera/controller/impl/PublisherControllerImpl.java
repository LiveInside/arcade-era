package org.nikita.arcadeera.controller.impl;

import lombok.AllArgsConstructor;
import org.nikita.arcadeera.controller.PublisherController;
import org.nikita.arcadeera.dto.PublisherDTO;
import org.nikita.arcadeera.service.PublisherService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class PublisherControllerImpl implements PublisherController {
    private final PublisherService publisherService;

    @Override
    public PublisherDTO getPublisherById(Integer id) {
        return publisherService.getPublisherById(id);
    }

    @Override
    public List<PublisherDTO> getAllPublisher() {
        return publisherService.getAllPublisher();
    }

    @Override
    public void createOrUpdatePublisher(PublisherDTO publisherDTO) {
        publisherService.createOrUpdatePublisher(publisherDTO);
    }

    @Override
    public void deleteUser(Integer id) {
        publisherService.deletePublisher(id);
    }
}
