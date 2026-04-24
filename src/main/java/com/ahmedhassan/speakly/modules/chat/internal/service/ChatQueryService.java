package com.ahmedhassan.speakly.modules.chat.internal.service;

import com.ahmedhassan.speakly.modules.user.api.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatQueryService {
    public String getChatName(UserDto sender, UserDto recipient) {
        if (sender.id().equals(recipient.id())) {
            return sender.firstName() + " " + sender.lastName();
        }
        return recipient.firstName() + " " + recipient.lastName();
    }
}
