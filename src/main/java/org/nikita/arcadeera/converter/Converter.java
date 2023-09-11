package org.nikita.arcadeera.converter;

public interface Converter<Input, Output> {
    Output convert(Input entity);
}
