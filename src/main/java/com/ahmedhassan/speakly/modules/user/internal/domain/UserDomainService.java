package com.ahmedhassan.speakly.modules.user.internal.domain;

import com.ahmedhassan.speakly.common.exception.EmailAlreadyExists;
import org.jspecify.annotations.NonNull;

public class UserDomainService {
    public void ensureEmailIsUnique(String email, @NonNull UserRepository userRepository) {
        if (userRepository.emailExists(email)) {
            throw new EmailAlreadyExists("Email already exists");
        }
    }
}
