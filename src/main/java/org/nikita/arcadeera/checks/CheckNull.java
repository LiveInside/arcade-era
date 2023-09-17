package org.nikita.arcadeera.checks;

import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

@Validated
public interface CheckNull<T> {
    void checkForNull(@NotNull(message = "Объект не найден. Обновить не удалось") T entity);
}
