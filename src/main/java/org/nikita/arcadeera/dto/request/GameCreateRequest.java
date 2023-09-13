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
public class GameCreateRequest {
    @NotBlank(message = "Поле не должно быть пустым или состоять из пробелов")
    private String name;

    @NotBlank(message = "Поле не должно быть пустым или состоять из пробелов")
    private String platform;

    @NotBlank(message = "Поле не должно быть пустым или состоять из пробелов")
    private String genre;

    @NotNull(message = "Поле должно быть заполнено")
    @Min(value = 0, message = "Значение должно быть положительным или равно 0")
    private BigDecimal price;

    @NotBlank(message = "Поле не должно быть пустым или состоять из пробелов")
    private String ageRating;

    @NotNull(message = "Поле должно быть заполнено")
    @Min(value = 0, message = "Значение должно быть положительным или равно 0")
    private BigDecimal userEvaluation;

    private boolean hide;
}
