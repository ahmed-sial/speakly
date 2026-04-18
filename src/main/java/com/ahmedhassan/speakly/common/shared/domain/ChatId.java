package com.ahmedhassan.speakly.common.shared.domain;

import org.jspecify.annotations.NonNull;

import java.util.Objects;
import java.util.UUID;

public class ChatId {

    private final UUID value;
    public ChatId(UUID value) {
        this.value = Objects.requireNonNull(value);
    }

    public static @NonNull ChatId generate() {
        return new ChatId(UUID.randomUUID());
    }

    public static @NonNull ChatId of(UUID value) {
        return new ChatId(value);
    }

    public UUID value() {
        return value;
    }

    @Override
    public String toString() {
       return value.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return false;
        if (!(o instanceof ChatId)) return false;
        ChatId chatId = (ChatId) o;
        return value.equals(chatId.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
