package com.ahmedhassan.speakly.modules.messages.internal.service;

import com.ahmedhassan.speakly.modules.messages.api.IMessageQueryService;
import com.ahmedhassan.speakly.modules.messages.internal.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static com.ahmedhassan.speakly.modules.messages.internal.entity.MessageState.SENT;

@Service
@RequiredArgsConstructor
public class MessageQueryService implements IMessageQueryService {

    private final MessageRepository messageRepository;

    @Override
    public int getUnreadMessagesCountBy(UUID recipientId) {
        return messageRepository
                .findMessagesByMessageState(SENT)
                .stream()
                .filter(message -> message.)
                .size();
    }

    @Override
    public String getLastMessage(UUID recipientId) {

    }
}
