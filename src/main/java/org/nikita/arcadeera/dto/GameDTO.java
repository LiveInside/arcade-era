package org.nikita.arcadeera.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import org.nikita.arcadeera.entity.User;

import java.math.BigDecimal;
import java.util.List;

@Data
@Accessors(chain = true)
public class GameDTO {

    private Integer id;

    private String name;

    private String platform;

    private String genre;

    private BigDecimal price;

    private String ageRating;

    private BigDecimal userEvaluation;

    private boolean hide;

    private List<User> users;
}
