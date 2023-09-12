package org.nikita.arcadeera.converter.publisher;

import lombok.extern.log4j.Log4j2;
import org.nikita.arcadeera.converter.Converter;
import org.nikita.arcadeera.dto.response.PublisherDTO;
import org.nikita.arcadeera.entity.Publisher;
import org.nikita.arcadeera.exception.ResourceNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@Log4j2
public class PublisherConverterToDTO implements Converter<Publisher, PublisherDTO> {

    @Override
    public PublisherDTO convert(Publisher publisher) {
        if (Objects.isNull(publisher)) {
            throw new ResourceNotFoundException("Издатель не найден");
        }
        return new PublisherDTO().setName(publisher.getName())
                .setCountry(publisher.getCountry())
                .setHide(publisher.isHide());
    }
}
