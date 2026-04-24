package com.ahmedhassan.speakly.modules.messages.internal.repository;

import com.ahmedhassan.speakly.modules.messages.internal.entity.Message;
import com.ahmedhassan.speakly.modules.messages.internal.entity.MessageState;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findMessagesByMessageState(MessageState messageState);
}
