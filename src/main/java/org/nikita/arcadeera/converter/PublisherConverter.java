package org.nikita.arcadeera.converter;

import org.nikita.arcadeera.dto.PublisherDTO;
import org.nikita.arcadeera.entity.Publisher;
import org.springframework.stereotype.Component;

@Component
public class PublisherConverter implements Converter<Publisher, PublisherDTO> {
    public PublisherDTO toDTO(Publisher publisher) {
        PublisherDTO publisherDTO = new PublisherDTO();
        publisherDTO.setId(publisher.getId());
        publisherDTO.setName(publisher.getName());
        publisherDTO.setCountry(publisher.getCountry());
        publisherDTO.setHide(publisher.isHide());
        publisherDTO.setGames(publisher.getGames());
        return publisherDTO;
    }
}
