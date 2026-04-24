package com.ahmedhassan.speakly.modules.user.internal.service;

import com.ahmedhassan.speakly.modules.user.api.IUserSynchronizer;
import com.ahmedhassan.speakly.modules.user.internal.entity.UserEntity;
import com.ahmedhassan.speakly.modules.user.internal.mapper.UserMapper;
import com.ahmedhassan.speakly.modules.user.internal.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserSynchronizer implements IUserSynchronizer {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public void synchronize(Jwt token) {
        getUserEmail(token).ifPresent(email -> {
            UserEntity user = userMapper.fromTokenClaims(token.getClaims());
            userRepository.save(user);
        });
    }

    private Optional<String> getUserEmail(Jwt token) {
        Map<String, Object> claims = token.getClaims();
        if (claims.containsKey("email")) {
            return Optional.of(claims.get("email").toString());
        }
        return Optional.empty();
    }
}
