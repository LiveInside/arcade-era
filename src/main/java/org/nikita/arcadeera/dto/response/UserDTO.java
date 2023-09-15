package org.nikita.arcadeera.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Getter
@Setter
@Accessors(chain = true)
@Schema(description = "Сущность пользователя, которая возвращается в ответе")
public class UserDTO {
    @Schema(description = "Идентификатор пользователя", accessMode = Schema.AccessMode.READ_ONLY)
    private Integer id;

    @Schema(description = "Регион пользователя")
    private String region;

    @Schema(description = "Возраст пользователя")
    private Short age;

    @Schema(description = "Баланс пользователя")
    private BigDecimal balance;

    @Schema(description = "Имя пользователя")
    private String name;
}
