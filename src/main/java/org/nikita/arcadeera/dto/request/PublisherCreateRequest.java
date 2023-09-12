package org.nikita.arcadeera.dto.request;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class PublisherCreateRequest {
    private String name;

    private String country;

    private boolean hide;

}
