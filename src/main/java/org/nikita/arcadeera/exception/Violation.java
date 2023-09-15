package org.nikita.arcadeera.exception;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@Schema(description = "Ошибка которая возвращается клиенту")
public class Violation {
    @Schema(description = "Поле в котором ошибка")
    private final String fieldName;
    @Schema(description = "Сообщение об ошибки")
    private final String message;
}
