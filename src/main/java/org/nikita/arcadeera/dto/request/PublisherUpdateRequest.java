package org.nikita.arcadeera.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@Schema(description = "Сущность для обновления пользователя")
public class PublisherUpdateRequest {
    @NotBlank(message = "Поле не должно быть пустым или состоять из пробелов")
    @Schema(description = "Страна издателя")
    private String country;

    @Schema(description = "Модификатор скрытия")
    private boolean hide;
}
