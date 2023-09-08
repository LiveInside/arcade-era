package org.nikita.arcadeera.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.nikita.arcadeera.converter.PublisherConverter;
import org.nikita.arcadeera.dto.PublisherDTO;
import org.nikita.arcadeera.entity.Publisher;
import org.nikita.arcadeera.exception.EmptyParam;
import org.nikita.arcadeera.repository.PublisherRepository;
import org.nikita.arcadeera.service.PublisherService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
@Log4j2
@AllArgsConstructor
public class PublisherServiceImpl implements PublisherService {
    private final PublisherRepository publisherRepository;
    private final PublisherConverter publisherConverter;

    @Override
    public PublisherDTO getPublisherById(Integer id) {
        Publisher publisher = publisherRepository.findById(id).orElse(null);
        if (Objects.isNull(publisher)) {
            log.info("Издатель не найден");
            return null;
        }
        return publisherConverter.toDTO(publisher);
    }

    @Override
    public List<PublisherDTO> getAllPublisher() {
        List<Publisher> publishers = publisherRepository.findAll();
        if (CollectionUtils.isEmpty(publishers)) {
            log.info("Таблица publisher пустая");
            return Collections.emptyList();
        }

        return publishers.stream()
                .map(publisherConverter::toDTO)
                .toList();
    }

    @Override
    public void createOrUpdatePublisher(PublisherDTO publisherDTO) {
        if (Objects.isNull(publisherDTO))
            throw new EmptyParam("Параметр пуст");

        Publisher publisher = publisherConverter.toEntity(publisherDTO);
        publisherRepository.save(publisher);
    }

    @Override
    public void deletePublisher(Integer id) {
        if (Objects.isNull(id))
            throw new EmptyParam("Параметр пуст");
        publisherRepository.deleteById(id);
    }
}
