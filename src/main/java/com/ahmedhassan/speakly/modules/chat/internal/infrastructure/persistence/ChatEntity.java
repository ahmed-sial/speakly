package com.ahmedhassan.speakly.modules.chat.internal.infrastructure.persistence;

import com.ahmedhassan.speakly.common.shared.persistence.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "chat", uniqueConstraints = {
        @UniqueConstraint(name = "uniqSenderRecipient", columnNames = {"sender_id", "recipient_id"})
})
public class ChatEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "sender_id", nullable = false)
    private UUID senderId;

    @Column(name = "recipient_id", nullable = false)
    private UUID recipientId;

}
