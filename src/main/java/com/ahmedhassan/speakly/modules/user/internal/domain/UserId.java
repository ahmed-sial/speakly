package com.ahmedhassan.speakly.modules.user.internal.domain;

import org.jspecify.annotations.NonNull;

import java.util.Objects;
import java.util.UUID;

public final class UserId {

    private final UUID value;
    private UserId(UUID value) {
        this.value = Objects.requireNonNull(value);
    }

    // Factory for new IDs
    public static @NonNull UserId generate() {
        return new UserId(UUID.randomUUID());
    }

    // Factory for existing IDs (from DB)
    public static @NonNull UserId of(UUID value) {
        return new UserId(value);
    }

    public @NonNull UUID value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserId)) return false;
        UserId userId = (UserId) o;
        return value.equals(userId.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
