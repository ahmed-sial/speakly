package com.ahmedhassan.speakly.modules.chat.internal.infrastructure.persistence;

import com.ahmedhassan.speakly.common.exception.ChatNotFoundException;
import com.ahmedhassan.speakly.common.shared.domain.ChatId;
import com.ahmedhassan.speakly.modules.chat.internal.application.ChatMapper;
import com.ahmedhassan.speakly.modules.chat.internal.domain.Chat;
import com.ahmedhassan.speakly.modules.chat.internal.domain.ChatRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ChatRepositoryAdapter implements ChatRepository {
    private final ChatJpaRepository chatJpaRepository;
    private final ChatMapper chatMapper;

    @Override
    public Chat findById(@NonNull ChatId chatId) {
        return chatJpaRepository.findById(chatId.value())
                .map(chatMapper::toDomain)
                .orElseThrow(() -> new ChatNotFoundException("Chat not found"));
    }

    @Override
    public Chat save(Chat chat) {
        ChatEntity savedChat = chatJpaRepository.save(chatMapper.toEntity(chat));
        return chatMapper.toDomain(savedChat);
    }

    @Override
    public Chat update(ChatId chatId, Chat chat) {
       return null; // TODO
    }

    @Override
    public void delete(ChatId chatId) {
        // TODO
    }
}
