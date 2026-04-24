package com.ahmedhassan.speakly.modules.user.api.dto;

import java.time.Instant;
import java.util.UUID;

public record UserDto(
        UUID id,
        String firstName,
        String lastName,
        String email,
        Instant lastSeenAt
) {
}
