package org.nikita.arcadeera.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(description = "Сущность для создания игры")
public class GameCreateRequest {
    @NotBlank(message = "Поле не должно быть пустым или состоять из пробелов")
    @Schema(description = "Название игры")
    private String name;

    @NotBlank(message = "Поле не должно быть пустым или состоять из пробелов")
    @Schema(description = "Название платформы на которой игра запускается")
    private String platform;

    @NotBlank(message = "Поле не должно быть пустым или состоять из пробелов")
    @Schema(description = "Жанр игры")
    private String genre;

    @NotNull(message = "Поле должно быть заполнено")
    @Min(value = 0, message = "Значение должно быть положительным или равно 0")
    @Schema(description = "Цена игры")
    private BigDecimal price;

    @NotBlank(message = "Поле не должно быть пустым или состоять из пробелов")
    @Schema(description = "Возрастной рейтинг")
    private String ageRating;

    @NotNull(message = "Поле должно быть заполнено")
    @Min(value = 0, message = "Значение должно быть положительным или равно 0")
    @Schema(description = "Оценка пользователей")
    private BigDecimal userEvaluation;

    @Schema(description = "Модификатор скрытия")
    private boolean hide;
}
