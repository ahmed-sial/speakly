package com.ahmedhassan.speakly.modules.messages.internal.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MessageJpaRepository extends JpaRepository<MessageEntity, UUID> {
}
