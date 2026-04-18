package com.ahmedhassan.speakly.modules.chat.internal.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ChatJpaRepository extends JpaRepository<ChatEntity, UUID> {
}
