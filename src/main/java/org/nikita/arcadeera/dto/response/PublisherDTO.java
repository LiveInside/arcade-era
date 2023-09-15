package org.nikita.arcadeera.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@Schema(description = "Сущность издателя, которая взвращается в ответе")
public class PublisherDTO {
    @Schema(description = "Идентификатор издателя", accessMode = Schema.AccessMode.READ_ONLY)
    private Integer id;

    @Schema(description = "Название издателя")
    private String name;

    @Schema(description = "Страна издателя")
    private String country;

    @Schema(description = "Модификатор скрытия")
    private boolean hide;
}
