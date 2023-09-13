package org.nikita.arcadeera.converter.publisher;

import lombok.extern.log4j.Log4j2;
import org.nikita.arcadeera.converter.Converter;
import org.nikita.arcadeera.dto.request.PublisherCreateRequest;
import org.nikita.arcadeera.entity.Publisher;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@Log4j2
public class PublisherCreateConverterToEntity implements Converter<PublisherCreateRequest, Publisher> {
    @Override
    public Publisher convert(PublisherCreateRequest publisherCreateRequest) {
        if (Objects.isNull(publisherCreateRequest)) {
            return null;
        }
        return new Publisher().setName(publisherCreateRequest.getName())
                .setCountry(publisherCreateRequest.getCountry())
                .setHide(publisherCreateRequest.isHide());
    }
}
