package com.ahmedhassan.speakly.modules.messages.internal.application;

import com.ahmedhassan.speakly.common.shared.domain.ChatId;
import com.ahmedhassan.speakly.common.shared.domain.MessageId;
import com.ahmedhassan.speakly.common.shared.domain.UserId;
import com.ahmedhassan.speakly.modules.messages.internal.domain.Message;
import com.ahmedhassan.speakly.modules.messages.internal.infrastructure.persistence.MessageEntity;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Component;

@Component
public class MessageMapper {
    public @NonNull Message toDomain(@NonNull MessageEntity entity) {
        return Message.reconstitute(
                MessageId.of(entity.getMessageId()),
                ChatId.of(entity.getChatId()),
                UserId.of(entity.getSenderId()),
                entity.getContent(),
                entity.getMessageType(),
                entity.getSentAt(),
                entity.getUpdatedAt(),
                entity.getReadAt()
        );
    }

    public @NonNull MessageEntity toEntity(@NonNull Message message) {
        MessageEntity entity = new MessageEntity();
        entity.setMessageId(message.getMessageId().value());
        entity.setChatId(message.getChatId().value());
        entity.setSenderId(message.getSenderId().value());
        entity.setContent(message.getContent());
        entity.setMessageType(message.getMessageType());
        entity.setSentAt(message.getSentAt());
        entity.setUpdatedAt(message.getUpdatedAt());
        entity.setReadAt(message.getReadAt());
        return entity;
    }
}
