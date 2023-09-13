package org.nikita.arcadeera.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class PublisherUpdateRequest {
    @NotBlank(message = "Поле не должно быть пустым или состоять из пробелов")
    private String country;

    private boolean hide;
}
