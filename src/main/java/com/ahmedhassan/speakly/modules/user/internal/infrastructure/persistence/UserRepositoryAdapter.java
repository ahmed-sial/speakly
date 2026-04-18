package com.ahmedhassan.speakly.modules.user.internal.infrastructure.persistence;

import com.ahmedhassan.speakly.common.exception.UserNotFoundException;
import com.ahmedhassan.speakly.common.shared.domain.UserId;
import com.ahmedhassan.speakly.modules.user.internal.application.UserMapper;
import com.ahmedhassan.speakly.modules.user.internal.domain.User;
import com.ahmedhassan.speakly.modules.user.internal.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserRepositoryAdapter implements UserRepository {
    private final UserJpaRepository userJpaRepository;
    private final UserMapper userMapper;

    @Override
    public User findById(@NonNull UserId userId) {
        return userJpaRepository.findById(userId.value())
                .map(userMapper::toDomain)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    @Override
    public User findByEmail(@NonNull String email) {
        return userJpaRepository.findByEmail(email)
                .map(userMapper::toDomain)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    @Override
    public boolean emailExists(String email) {
        return userJpaRepository.existsByEmail(email);
    }


    @Override
    public User save(User user) {
        var savedUser = userJpaRepository.save(userMapper.toEntity(user));
        return userMapper.toDomain(savedUser);
    }

    @Override
    public User update(UserId userId, User user) {
        return null; // TODO
    }

    @Override
    public void delete(UserId userId) {
        // TODO
    }
}

// TODO: UserId already generated in User domain model, so should GenerationType be added in UserEntity?