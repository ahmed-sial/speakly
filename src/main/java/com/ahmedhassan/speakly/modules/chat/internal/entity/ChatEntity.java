package com.ahmedhassan.speakly.modules.chat.internal.entity;

import com.ahmedhassan.speakly.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Getter
@Setter
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(
        name = "chat",
        uniqueConstraints = @UniqueConstraint(
                name = "uniqueUserAndRecipient",
                columnNames= {"userId", "recipientId"}
        )
)
public class ChatEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private UUID userId;

    @Column(nullable = false)
    private UUID recipientId;
}
