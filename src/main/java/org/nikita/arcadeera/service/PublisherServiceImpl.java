package org.nikita.arcadeera.service;

import org.nikita.arcadeera.converter.PublisherConverter;
import org.nikita.arcadeera.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublisherServiceImpl implements PublisherService{
    private final PublisherRepository publisherRepository;
    private final PublisherConverter publisherConverter;

    @Autowired
    public PublisherServiceImpl(PublisherRepository publisherRepository,
                                PublisherConverter publisherConverter) {
        this.publisherRepository = publisherRepository;
        this.publisherConverter = publisherConverter;
    }
}
