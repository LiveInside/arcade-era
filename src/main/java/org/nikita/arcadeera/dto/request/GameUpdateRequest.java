package org.nikita.arcadeera.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Getter
@Setter
@Accessors(chain = true)
@Schema(description = "Сущность для обновления игры")
public class GameUpdateRequest {
    @NotNull(message = "Поле должно быть заполнено")
    @Min(value = 0, message = "Значение должно быть положительным или равно 0")
    @Schema(description = "Цена игры")
    private BigDecimal price;

    @NotNull(message = "Поле должно быть заполнено")
    @Min(value = 0, message = "Значение должно быть положительным или равно 0")
    @Schema(description = "Оценка пользователей")
    private BigDecimal userEvaluation;

    @Schema(description = "Модификатор скрытия")
    private boolean hide;
}
