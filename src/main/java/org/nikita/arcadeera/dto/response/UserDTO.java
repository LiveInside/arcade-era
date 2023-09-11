package org.nikita.arcadeera.dto.response;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Getter
@Setter
@Accessors(chain = true)
public class UserDTO {

    private Integer id;

    private String region;

    private Short age;

    private BigDecimal balance;

    private String name;
}
