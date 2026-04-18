package com.ahmedhassan.speakly.modules.chat.internal.application;

import com.ahmedhassan.speakly.common.shared.domain.ChatId;
import com.ahmedhassan.speakly.common.shared.domain.UserId;
import com.ahmedhassan.speakly.modules.chat.internal.domain.Chat;
import com.ahmedhassan.speakly.modules.chat.internal.infrastructure.persistence.ChatEntity;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Component;

@Component
public class ChatMapper {
    public @NonNull Chat toDomain(@NonNull ChatEntity entity) {
        return Chat.reconstitute(
                ChatId.of(entity.getId()),
                UserId.of(entity.getSenderId()),
                UserId.of(entity.getRecipientId())
        );
    }

    public @NonNull ChatEntity toEntity(@NonNull Chat chat) {
        ChatEntity entity = new ChatEntity();
        entity.setId(chat.getChatId().value());
        entity.setSenderId(chat.getSenderId().value());
        entity.setRecipientId(chat.getRecipientId().value());
        return entity;
    }
}
