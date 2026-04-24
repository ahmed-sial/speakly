package com.ahmedhassan.speakly.modules.messages.api;

import java.util.UUID;

public interface IMessageQueryService {
    int getUnreadMessagesCountBy(UUID recipientId);
    String getLastMessage(UUID recipientId);
}
