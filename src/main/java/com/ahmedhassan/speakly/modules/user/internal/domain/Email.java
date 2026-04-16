package com.ahmedhassan.speakly.modules.user.internal.domain;

import org.jspecify.annotations.NonNull;

import java.util.Objects;
import java.util.regex.Pattern;

public final class Email {

    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    private final String value;
    public Email(String value) {
        this.value = value;
    }

    public static @NonNull Email of(String value) {
        Objects.requireNonNull(value, "Email cannot be null");
        String normalized = value.trim().toLowerCase();
        if (!EMAIL_PATTERN.matcher(normalized).matches()) {
            throw new IllegalArgumentException("Invalid email address: " + value);
        }
        return new Email(normalized);
    }

    public boolean isValid(Email email) {
        if (email == null) return false;
        return EMAIL_PATTERN.matcher(email.value).matches();
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Email)) return false;
        Email email = (Email) o;
        return value.equals(email.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public String toString() {
        return value;
    }
}
