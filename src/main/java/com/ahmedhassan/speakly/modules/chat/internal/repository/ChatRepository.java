package com.ahmedhassan.speakly.modules.chat.internal.repository;

import com.ahmedhassan.speakly.modules.chat.internal.entity.ChatEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ChatRepository extends JpaRepository<ChatEntity, UUID> {
    List<ChatEntity> findChatEntitiesBySenderId(UUID senderId);
}
