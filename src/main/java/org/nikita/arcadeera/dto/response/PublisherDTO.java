package org.nikita.arcadeera.dto.response;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class PublisherDTO {

    private Integer id;

    private String name;

    private String country;

    private boolean hide;

}
