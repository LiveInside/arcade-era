package org.nikita.arcadeera.converter.publisher;

import lombok.extern.log4j.Log4j2;
import org.nikita.arcadeera.converter.Converter;
import org.nikita.arcadeera.dto.response.PublisherDTO;
import org.nikita.arcadeera.entity.Publisher;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@Log4j2
public class PublisherConverterToEntity implements Converter<PublisherDTO, Publisher> {

    @Override
    public Publisher convert(PublisherDTO publisherDTO) {
        if (Objects.isNull(publisherDTO)) {
            return null;
        }
        return new Publisher().setName(publisherDTO.getName())
                .setCountry(publisherDTO.getCountry())
                .setHide(publisherDTO.isHide());
    }
}
