package org.nikita.arcadeera.dto.request;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class PublisherUpdateRequest {
    private String country;

    private boolean hide;
}
