package org.nikita.arcadeera.exception;

public class EmptyParam extends RuntimeException {
    public EmptyParam(final String param) {
        super(param);
    }
}
