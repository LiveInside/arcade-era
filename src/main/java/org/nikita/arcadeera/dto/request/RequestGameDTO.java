package org.nikita.arcadeera.dto.request;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Getter
@Setter
@Accessors(chain = true)
public class RequestGameDTO {
    private BigDecimal price;

    private BigDecimal userEvaluation;

    private boolean hide;
}