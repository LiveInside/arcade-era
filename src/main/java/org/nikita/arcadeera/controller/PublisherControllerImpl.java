package org.nikita.arcadeera.controller;

import org.nikita.arcadeera.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublisherControllerImpl implements PublisherController {
    private final PublisherService publisherService;

    @Autowired
    public PublisherControllerImpl(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    // Реализация методов контроллера
}
