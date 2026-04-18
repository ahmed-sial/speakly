package com.ahmedhassan.speakly.modules.user.internal.application;

import com.ahmedhassan.speakly.common.shared.domain.UserId;
import com.ahmedhassan.speakly.modules.user.internal.domain.Email;
import com.ahmedhassan.speakly.modules.user.internal.domain.User;
import com.ahmedhassan.speakly.modules.user.internal.infrastructure.persistence.UserEntity;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User toDomain(@NonNull UserEntity userEntity) {
        return User.reconstitute(
                UserId.of(userEntity.getUserId()),
                userEntity.getFullName(),
                Email.of(userEntity.getEmail()),
                userEntity.getPasswordHash(),
                userEntity.getIsActive(),
                userEntity.getLastSeen()
        );
    }

    public UserEntity toEntity(@NonNull User domain) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserId(domain.getUserId().value());
        userEntity.setFullName(domain.getFullName());
        userEntity.setEmail(domain.getEmail().value());
        userEntity.setPasswordHash(domain.getPasswordHash());
        userEntity.setIsActive(domain.isActive());
        userEntity.setLastSeen(domain.getLastSeen());
        return userEntity;
    }
}
