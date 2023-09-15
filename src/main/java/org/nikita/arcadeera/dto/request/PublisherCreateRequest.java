package org.nikita.arcadeera.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@Schema(description = "Сущность для создания издателя")
public class PublisherCreateRequest {
    @NotBlank(message = "Поле не должно быть пустым или состоять из пробелов")
    @Schema(description = "Название издателя")
    private String name;

    @NotBlank(message = "Поле не должно быть пустым или состоять из пробелов")
    @Schema(description = "Страна издателя")
    private String country;

    @Schema(description = "Модификатор скрытия")
    private boolean hide;

}
