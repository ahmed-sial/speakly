package com.ahmedhassan.speakly.modules.user.internal.mapper;

import com.ahmedhassan.speakly.modules.user.internal.entity.UserEntity;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Map;
import java.util.UUID;

@Component
public class UserMapper {

    public UserEntity fromTokenClaims(@NonNull Map<String, Object> claims) {
        UserEntity userEntity = new UserEntity();
        if (claims.containsKey("sub")) {
            userEntity.setId((UUID) claims.get("sub"));
        }

        if (claims.containsKey("given_name")) {
            userEntity.setFirstName(claims.get("given_name").toString());
        } else if (claims.containsKey("nickname")) {
            userEntity.setFirstName(claims.get("nickname").toString());
        }

        if (claims.containsKey("family_name")) {
            userEntity.setLastName(claims.get("family_name").toString());
        }

        if (claims.containsKey("email")) {
            userEntity.setEmail(claims.get("email").toString());
        }

        userEntity.setLastSeenAt(Instant.now());

        return userEntity;
    }
}
