package com.Zweb.backend.exception;

import java.time.LocalDateTime;

public record Error(
        String message,
        LocalDateTime timestamp
) {
}
