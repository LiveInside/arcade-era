package org.nikita.arcadeera.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Getter
@Setter
@Accessors(chain = true)
public class GameUpdateRequest {
    @NotNull(message = "Поле должно быть заполнено")
    @Min(value = 0, message = "Значение должно быть положительным или равно 0")
    private BigDecimal price;

    @NotNull(message = "Поле должно быть заполнено")
    @Min(value = 0, message = "Значение должно быть положительным или равно 0")
    private BigDecimal userEvaluation;

    private boolean hide;
}
