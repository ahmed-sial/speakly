package com.ahmedhassan.speakly.modules.chat.internal.service;

import com.ahmedhassan.speakly.modules.chat.api.dto.ChatResponse;
import com.ahmedhassan.speakly.modules.chat.internal.mapper.ChatMapper;
import com.ahmedhassan.speakly.modules.chat.internal.repository.ChatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatService {

    private final ChatRepository chatRepository;
    private final ChatMapper chatMapper;

    @Transactional(readOnly = true)
    public List<ChatResponse> getChatsForCurrentUser(Authentication authentication) {
        final var userId = authentication.getName();
        var chats = chatRepository.findChatEntitiesBySenderId(userId)
                .stream()
                .map(chat -> chatMapper.toChatResponse(chat, ))
                .toList();
    }
}
