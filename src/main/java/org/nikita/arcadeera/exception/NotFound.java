package org.nikita.arcadeera.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class NotFound {
    private int status;
    private String message;
}