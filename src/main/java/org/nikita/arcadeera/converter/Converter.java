package org.nikita.arcadeera.converter;

public interface Converter<V, T> {
    T toDTO(V entity);

    V toEntity(T dto);
}
