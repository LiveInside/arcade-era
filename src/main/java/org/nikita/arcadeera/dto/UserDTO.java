package org.nikita.arcadeera.dto;

import lombok.Getter;
import lombok.Setter;
import org.nikita.arcadeera.entity.Game;

import java.math.BigDecimal;

public class UserDTO {
    @Getter @Setter
    private Integer id;
    @Getter @Setter
    private String region;
    @Getter @Setter
    private Short age;
    @Getter @Setter
    private BigDecimal balance;
    @Getter @Setter
    private String name;
    @Getter @Setter
    private Game game;
}
