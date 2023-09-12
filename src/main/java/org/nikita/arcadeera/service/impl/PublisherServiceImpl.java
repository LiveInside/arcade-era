package org.nikita.arcadeera.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.nikita.arcadeera.converter.Converter;
import org.nikita.arcadeera.dto.request.PublisherCreateRequest;
import org.nikita.arcadeera.dto.request.PublisherUpdateRequest;
import org.nikita.arcadeera.dto.response.PublisherDTO;
import org.nikita.arcadeera.entity.Publisher;
import org.nikita.arcadeera.exception.EmptyParamException;
import org.nikita.arcadeera.exception.ResourceNotFoundException;
import org.nikita.arcadeera.repository.PublisherRepository;
import org.nikita.arcadeera.service.PublisherService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
@Log4j2
@AllArgsConstructor
public class PublisherServiceImpl implements PublisherService {
    private final PublisherRepository publisherRepository;
    private final Converter<Publisher, PublisherDTO> publisherConverterToDTO;
    private final Converter<PublisherDTO, Publisher> publisherConverterToEntity;
    private final Converter<PublisherCreateRequest, Publisher> publisherCreateConverterToEntity;


    @Override
    public PublisherDTO getPublisherById(Integer id) {
        Publisher publisher = publisherRepository.findById(id).orElse(null);
        return publisherConverterToDTO.convert(publisher);
    }

    @Override
    public List<PublisherDTO> getAllPublisher() {
        List<Publisher> publishers = publisherRepository.findAll();
        if (CollectionUtils.isEmpty(publishers)) {
            throw new ResourceNotFoundException("Таблица publisher пустая");
        }

        return publishers.stream()
                .map(publisherConverterToDTO::convert)
                .toList();
    }

    @Override
    public PublisherDTO createPublisher(PublisherCreateRequest publisherCreateRequest) {
        if (publisherCreateRequest.getName() == null)
            throw new EmptyParamException("Поле Name обязательно к заполнению");

        Publisher publisher = publisherCreateConverterToEntity.convert(publisherCreateRequest);
        publisherRepository.save(publisher);
        return publisherConverterToDTO.convert(publisher);
    }

    @Override
    public PublisherDTO updatePublisher(PublisherUpdateRequest publisherUpdateRequest, Integer id) {
        Publisher publisher = publisherRepository.findById(id).orElse(null);
        PublisherDTO updatedPublisherDTO = publisherConverterToDTO.convert(publisher);

        if (publisherUpdateRequest.getCountry() == null || publisherUpdateRequest.getCountry().isEmpty()) {
            throw new EmptyParamException("Поле Страна обязательно для заполнения");
        }

        updatedPublisherDTO.setCountry(publisherUpdateRequest.getCountry())
                .setHide(publisherUpdateRequest.isHide());

        Publisher updatedPublisher = publisherConverterToEntity.convert(updatedPublisherDTO);
        publisherRepository.save(updatedPublisher);
        return updatedPublisherDTO;
    }

    @Override
    public void deletePublisher(Integer id) {
        publisherRepository.deleteById(id);
    }
}
