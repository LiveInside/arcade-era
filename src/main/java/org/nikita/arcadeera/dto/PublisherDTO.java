package org.nikita.arcadeera.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import org.nikita.arcadeera.entity.Game;

import java.util.List;

@Data
@Accessors(chain = true)
public class PublisherDTO {

    private Integer id;

    private String name;

    private String country;

    private boolean hide;

    private List<Game> games;
}
