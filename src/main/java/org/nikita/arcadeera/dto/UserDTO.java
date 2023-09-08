package org.nikita.arcadeera.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import org.nikita.arcadeera.entity.Game;

import java.math.BigDecimal;

@Data
@Accessors(chain = true)
public class UserDTO {

    private Integer id;

    private String region;

    private Short age;

    private BigDecimal balance;

    private String name;
}
