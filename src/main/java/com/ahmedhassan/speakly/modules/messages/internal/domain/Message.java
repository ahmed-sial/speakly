package com.ahmedhassan.speakly.modules.messages.internal.domain;

import com.ahmedhassan.speakly.common.shared.domain.ChatId;
import com.ahmedhassan.speakly.common.shared.domain.MessageId;
import org.jspecify.annotations.NonNull;

import java.time.Instant;

public class Message {
    private final MessageId messageId;
    private ChatId chatId;
    private String content; // if the message is of type other that text, then the url of that resource will be content
    private MessageType messageType;
    private Instant sentAt;
    private Instant readAt;

    public Message(MessageId messageId, ChatId chatId, String content, MessageType messageType) {
        this.messageId = messageId;
        this.chatId = chatId;
        this.content = content;
        this.messageType = messageType;
        this.sentAt = Instant.now();
        this.readAt = null;
    }

    public static @NonNull Message createMessage(ChatId chatId, String content, MessageType messageType) {
        if (chatId == null || content == null || content.isBlank()) {
            throw new IllegalArgumentException("Chat ID or content cannot be null or blank");
        }
        return new Message(
                MessageId.generate(),
                chatId,
                content,
                messageType
        );
    }

    // only text message is allowed to change
    public Message changeMessage(String newContent) {
       if (newContent == null || newContent.isBlank()) {
           throw new IllegalArgumentException("New content cannot be null or blank");
       }
       this.content = newContent;
       this.sentAt = Instant.now();
       this.readAt = null;
       return this;
    }

    public void readMessage() {
        this.readAt = Instant.now();
    }
}
