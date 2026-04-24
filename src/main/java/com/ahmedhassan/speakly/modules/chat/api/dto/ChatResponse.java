package com.ahmedhassan.speakly.modules.chat.api.dto;

import lombok.Builder;

import java.time.Instant;
import java.util.UUID;

@Builder
public record ChatResponse(
        UUID chatId,
        String chatName,
        Integer unreadCount,
        String lastMessage,
        Instant lastMessageAt,
        Boolean isRecipientOnline,
        UUID senderId,
        UUID recipientId
) {}
