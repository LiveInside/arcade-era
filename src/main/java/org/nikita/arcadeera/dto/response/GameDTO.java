package org.nikita.arcadeera.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Getter
@Setter
@Accessors(chain = true)
@Schema(description = "Сущность игры, которая возвращается в ответе")
public class GameDTO {

    @Schema(description = "Идентификатор игры", accessMode = Schema.AccessMode.READ_ONLY)
    private Integer id;

    @Schema(description = "Название игры")
    private String name;

    @Schema(description = "Название платформы на которой игра запускается")
    private String platform;

    @Schema(description = "Жанр игры")
    private String genre;

    @Schema(description = "Цена игры")
    private BigDecimal price;

    @Schema(description = "Возрастной рейтинг игры")
    private String ageRating;

    @Schema(description = "Оценка пользователей")
    private BigDecimal userEvaluation;

    @Schema(description = "Модификатор скрытия")
    private boolean hide;
}
