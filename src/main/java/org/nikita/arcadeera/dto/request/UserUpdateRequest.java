package org.nikita.arcadeera.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Getter
@Setter
@Accessors(chain = true)
public class UserUpdateRequest {
    @NotBlank(message = "Поле не должно быть пустым или состоять из пробелов")
    private String region;

    @NotNull(message = "Поле должно быть заполнено")
    @Min(value = 0, message = "Значение должно быть положительным или равно 0")
    private BigDecimal balance;

    @NotBlank(message = "Поле не должно быть пустым или состоять из пробелов")
    private String name;
}
