package com.ahmedhassan.speakly.modules.messages.internal.domain;

import com.ahmedhassan.speakly.common.shared.domain.ChatId;
import com.ahmedhassan.speakly.common.shared.domain.MessageId;
import com.ahmedhassan.speakly.common.shared.domain.UserId;
import lombok.Getter;
import org.jspecify.annotations.NonNull;

import java.time.Instant;

@Getter
public class Message {
    private final MessageId messageId;
    private final ChatId chatId;
    private final UserId senderId;
    private String content; // if the message is of type other that text, then the url of that resource will be content
    private final MessageType messageType;
    private final Instant sentAt;
    private Instant updatedAt;
    private Instant readAt;

    public Message(MessageId messageId, ChatId chatId, UserId senderId, String content, MessageType messageType) {
        this.messageId = messageId;
        this.chatId = chatId;
        this.senderId = senderId;
        this.content = content;
        this.messageType = messageType;
        this.sentAt = Instant.now();
        this.updatedAt = null;
        this.readAt = null;
    }

    public Message(MessageId messageId, ChatId chatId, UserId senderId, String content, MessageType messageType, Instant sentAt, Instant updatedAt, Instant readAt) {
        this.messageId = messageId;
        this.chatId = chatId;
        this.senderId = senderId;
        this.content = content;
        this.messageType = messageType;
        this.sentAt = Instant.now();
        this.updatedAt = updatedAt;
        this.readAt = readAt;
    }

    public static @NonNull Message create(ChatId chatId, UserId senderId, String content, MessageType messageType) {
        if (chatId == null || senderId == null)
            throw new IllegalArgumentException("Chat ID or sender ID cannot be null");
        else if (content == null || content.isEmpty())
            throw new IllegalArgumentException("Content cannot be null or empty");

        return new Message(
                MessageId.generate(),
                chatId,
                senderId,
                content,
                messageType
        );
    }

    // only text message is allowed to change
    public void changeContent(String newContent) {
        if (this.messageType != MessageType.TEXT)
            throw new IllegalStateException("Cannot change content on non-text message");
        if (newContent == null || newContent.isBlank()) {
            throw new IllegalArgumentException("New content cannot be null or blank");
        }
        this.content = newContent;
        this.updatedAt = Instant.now();
        this.readAt = null;
    }

    public static @NonNull Message reconstitute(
            MessageId messageId,
            ChatId chatId,
            UserId senderId,
            String content,
            MessageType messageType,
            Instant sentAt,
            Instant updatedAt,
            Instant readAt
    ) {
        return new Message(messageId, chatId, senderId, content, messageType, sentAt, updatedAt, readAt);
    }

    public void markAsRead() {
        this.readAt = Instant.now();
    }
}
