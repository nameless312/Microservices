package com.nameless.application.exceptions;

import java.time.LocalDateTime;
import java.util.List;

public record DefaultError(
        LocalDateTime timestamp,
        int status,
        List<String> errors,
        String path
) {
}
