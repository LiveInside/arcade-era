package org.nikita.arcadeera.dto;

import lombok.Getter;
import lombok.Setter;
import org.nikita.arcadeera.entity.Publisher;
import org.nikita.arcadeera.entity.User;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class GameDTO {
    @Getter @Setter
    private Integer id;
    @Getter @Setter
    private String name;
    @Getter @Setter
    private String platform;
    @Getter @Setter
    private String genre;
    @Getter @Setter
    private BigDecimal price;
    @Getter @Setter
    private String ageRating;
    @Getter @Setter
    private BigDecimal userEvaluation;
    @Getter @Setter
    private boolean hide;
    @Getter @Setter
    private Publisher publisher;
    @Getter @Setter
    private List<User> users = new ArrayList<>();
}
