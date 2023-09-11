package org.nikita.arcadeera.dto.request;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Getter
@Setter
@Accessors(chain = true)
public class RequestUserDTO {
    private String region;

    private BigDecimal balance;

    private String name;
}
