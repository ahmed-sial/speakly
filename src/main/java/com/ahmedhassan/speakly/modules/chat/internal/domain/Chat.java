package com.ahmedhassan.speakly.modules.chat.internal.domain;

import com.ahmedhassan.speakly.common.shared.domain.ChatId;
import com.ahmedhassan.speakly.common.shared.domain.UserId;
import org.jspecify.annotations.NonNull;

public class Chat {
    private final ChatId chatId;
    private UserId recipientId;
    private UserId senderId;

    public Chat(ChatId chatId, UserId senderId, UserId recipientId) {
        this.chatId = chatId;
        this.senderId = senderId;
        this.recipientId = recipientId;
    }

    public static @NonNull Chat createChat(UserId senderId, UserId recipientId) {
        if (senderId == null || recipientId == null) {
            throw new IllegalArgumentException("Sender and recipient can't be null.");
        } else if (senderId.equals(recipientId)) {
            throw new IllegalArgumentException("Sender and recipient can't be the same.");
        }
        return new Chat(
                ChatId.generate(),
                senderId,
                recipientId);
    }
}
