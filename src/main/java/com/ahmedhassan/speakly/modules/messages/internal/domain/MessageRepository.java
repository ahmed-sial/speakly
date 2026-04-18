package com.ahmedhassan.speakly.modules.messages.internal.domain;

import com.ahmedhassan.speakly.common.shared.domain.MessageId;

public interface MessageRepository {
    Message findById(MessageId messageId);
    Message save(Message message);
    Message update(MessageId messageId, Message message);
    void delete(MessageId messageId);
}
