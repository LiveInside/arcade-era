package org.nikita.arcadeera.exception;

public class EmptyParamException extends RuntimeException {
    public EmptyParamException(final String param) {
        super(param);
    }
}
