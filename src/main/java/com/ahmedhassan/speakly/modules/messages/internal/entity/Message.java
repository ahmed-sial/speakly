package com.ahmedhassan.speakly.modules.messages.internal.entity;

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
@Table(name = "message")
public class Message {
    @Id
    @SequenceGenerator(
            name = "msg_seq",
            sequenceName = "msg_seq",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "msg_seq")
    private Long id;

    @Column(nullable = false)
    private UUID chatId;

    @Column(nullable = false)
    private UUID senderId;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Enumerated(EnumType.STRING)
    private MessageState messageState;

    @Enumerated(EnumType.STRING)
    private MessageType messageType;

}
