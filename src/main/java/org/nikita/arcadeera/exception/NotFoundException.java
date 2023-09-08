package org.nikita.arcadeera.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(final String entity) {
        super(entity + " не найден");
    }
}
