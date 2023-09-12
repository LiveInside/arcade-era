package org.nikita.arcadeera.dto.request;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Getter
@Setter
@Accessors(chain = true)
public class GameCreateRequest {
    private String name;

    private String platform;

    private String genre;

    private BigDecimal price;

    private String ageRating;

    private BigDecimal userEvaluation;

    private boolean hide;
}
