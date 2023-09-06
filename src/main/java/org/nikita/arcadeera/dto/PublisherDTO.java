package org.nikita.arcadeera.dto;

import lombok.Getter;
import lombok.Setter;
import org.nikita.arcadeera.entity.Game;

import java.util.ArrayList;
import java.util.List;

public class PublisherDTO {
    @Getter @Setter
    private Integer id;
    @Getter @Setter
    private String name;
    @Getter @Setter
    private String country;
    @Getter @Setter
    private boolean hide;
    @Getter @Setter
    private List<Game> games = new ArrayList<>();
}
