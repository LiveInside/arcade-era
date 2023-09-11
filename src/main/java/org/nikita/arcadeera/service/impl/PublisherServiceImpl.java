package org.nikita.arcadeera.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.nikita.arcadeera.converter.publisher.PublisherConverterToDTO;
import org.nikita.arcadeera.converter.publisher.PublisherConverterToEntity;
import org.nikita.arcadeera.dto.request.RequestPublisherDTO;
import org.nikita.arcadeera.dto.response.PublisherDTO;
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
    private final PublisherConverterToDTO publisherConverterToDTO;
    private final PublisherConverterToEntity publisherConverterToEntity;


    @Override
    public PublisherDTO getPublisherById(Integer id) {
        Publisher publisher = publisherRepository.findById(id).orElse(null);
        return publisherConverterToDTO.convert(publisher);
    }

    @Override
    public List<PublisherDTO> getAllPublisher() {
        List<Publisher> publishers = publisherRepository.findAll();
        if (CollectionUtils.isEmpty(publishers)) {
            log.info("Таблица publisher пустая");
            return Collections.emptyList();
        }

        return publishers.stream()
                .map(publisherConverterToDTO::convert)
                .toList();
    }

    @Override
    public PublisherDTO createPublisher(PublisherDTO publisherDTO) {
        Publisher publisher = publisherConverterToEntity.convert(publisherDTO);
        publisherRepository.save(publisher);
        return publisherConverterToDTO.convert(publisher);
    }

    @Override
    public PublisherDTO updatePublisher(RequestPublisherDTO publisherDTO, Integer id) {
        Publisher publisher = publisherRepository.findById(id).orElse(null);
        PublisherDTO updatedPublisherDTO = publisherConverterToDTO.convert(publisher);

        if (publisherDTO.getCountry().isEmpty()) {
            throw new EmptyParam("Поле \"Страна\" обязательно для заполнения");
        }

        updatedPublisherDTO.setCountry(publisherDTO.getCountry())
                .setHide(publisherDTO.isHide());

        Publisher updatedPublisher = publisherConverterToEntity.convert(updatedPublisherDTO);
        publisherRepository.save(updatedPublisher);
        return updatedPublisherDTO;
    }

    @Override
    public void deletePublisher(Integer id) {
        if (Objects.isNull(id))
            throw new EmptyParam("Параметр пуст");
        publisherRepository.deleteById(id);
    }
}
