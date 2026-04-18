package com.ahmedhassan.speakly.common.shared.domain;

import org.jspecify.annotations.NonNull;

import java.util.Objects;
import java.util.UUID;

public class MessageId {

    private final UUID value;
    public MessageId(UUID value) {
        this.value = Objects.requireNonNull(value);
    }

    public static @NonNull MessageId generate() {
        return new MessageId(UUID.randomUUID());
    }

    public static @NonNull MessageId of(UUID value) {
        return new MessageId(value);
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
        if (!(o instanceof MessageId)) return false;
        MessageId chatId = (MessageId) o;
        return value.equals(chatId.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
