package org.nikita.arcadeera.converter;

import lombok.extern.log4j.Log4j2;
import org.nikita.arcadeera.dto.PublisherDTO;
import org.nikita.arcadeera.entity.Publisher;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class PublisherConverter implements Converter<Publisher, PublisherDTO> {
    @Override
    public PublisherDTO toDTO(Publisher publisher) {
        return new PublisherDTO()
                .setId(publisher.getId())
                .setName(publisher.getName())
                .setCountry(publisher.getCountry())
                .setHide(publisher.isHide())
                .setGames(publisher.getGames());
    }

    @Override
    public Publisher toEntity(PublisherDTO publisherDTO) {
        return new Publisher()
                .setId(publisherDTO.getId())
                .setName(publisherDTO.getName())
                .setCountry(publisherDTO.getCountry())
                .setHide(publisherDTO.isHide())
                .setGames(publisherDTO.getGames());
    }
}
