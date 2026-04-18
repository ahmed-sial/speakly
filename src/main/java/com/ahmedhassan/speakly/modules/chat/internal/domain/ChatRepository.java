package com.ahmedhassan.speakly.modules.chat.internal.domain;

import com.ahmedhassan.speakly.common.shared.domain.ChatId;

public interface ChatRepository {
    Chat findById(ChatId chatId);
    Chat save(Chat chat);
    Chat update(ChatId chatId, Chat chat);
    void delete(ChatId chatId);
}
