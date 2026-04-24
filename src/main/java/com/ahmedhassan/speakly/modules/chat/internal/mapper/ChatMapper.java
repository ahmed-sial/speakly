package com.ahmedhassan.speakly.modules.chat.internal.mapper;

import com.ahmedhassan.speakly.modules.chat.api.dto.ChatResponse;
import com.ahmedhassan.speakly.modules.chat.internal.entity.ChatEntity;
import com.ahmedhassan.speakly.modules.chat.internal.service.ChatQueryService;
import com.ahmedhassan.speakly.modules.messages.api.IMessageQueryService;
import com.ahmedhassan.speakly.modules.user.api.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ChatMapper {

    private ChatQueryService chatQueryService;
    private IMessageQueryService messageQueryService;

    public ChatResponse toChatResponse(ChatEntity chatEntity, UserDto sender, UserDto recipient) {
        return ChatResponse
                .builder()
                .chatId(chatEntity.getId())
                .chatName(chatQueryService.getChatName(sender, recipient))
                .unreadCount(messageQueryService.getUnreadMessagesCountBy(recipient.id()))
                .lastMessage()
                .lastMessageAt()
                .isRecipientOnline()
                .senderId()
                .recipientId()
                .build();
    }
}
