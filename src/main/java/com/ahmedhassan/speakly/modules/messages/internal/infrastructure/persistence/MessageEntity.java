package com.ahmedhassan.speakly.modules.messages.internal.infrastructure.persistence;

import com.ahmedhassan.speakly.common.shared.persistence.BaseEntity;
import com.ahmedhassan.speakly.modules.messages.internal.domain.MessageType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "messages")
public class MessageEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID messageId;
    @Column(nullable = false, updatable = false)
    private UUID chatId;
    @Column(nullable = false, updatable = false)
    private UUID senderId;
    @Column(nullable = false)
    private String content;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, updatable = false)
    private MessageType messageType;
    @Column(nullable = false, updatable = false)
    private Instant sentAt;
    private Instant updatedAt;
    private Instant readAt;
}
