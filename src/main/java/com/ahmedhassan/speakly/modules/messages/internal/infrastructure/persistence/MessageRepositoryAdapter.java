package com.ahmedhassan.speakly.modules.messages.internal.infrastructure.persistence;

import com.ahmedhassan.speakly.common.exception.MessageNotFoundException;
import com.ahmedhassan.speakly.common.shared.domain.MessageId;
import com.ahmedhassan.speakly.modules.messages.internal.application.MessageMapper;
import com.ahmedhassan.speakly.modules.messages.internal.domain.Message;
import com.ahmedhassan.speakly.modules.messages.internal.domain.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MessageRepositoryAdapter implements MessageRepository {

    private final MessageJpaRepository messageJpaRepository;
    private final MessageMapper messageMapper;

    @Override
    public Message findById(@NonNull MessageId messageId) {
        return messageJpaRepository.findById(messageId.value())
                .map(messageMapper::toDomain)
                .orElseThrow(() -> new MessageNotFoundException("Message not found"));
    }

    @Override
    public Message save(Message message) {
        MessageEntity savedMessage = messageJpaRepository.save(messageMapper.toEntity(message));
        return messageMapper.toDomain(savedMessage);
    }

    @Override
    public Message update(MessageId messageId, Message message) {
        return null; // TODO
    }

    @Override
    public void delete(MessageId messageId) {
        // TODO
    }
}
