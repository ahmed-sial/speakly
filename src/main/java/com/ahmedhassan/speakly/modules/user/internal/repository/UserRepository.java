package com.ahmedhassan.speakly.modules.user.internal.repository;

import com.ahmedhassan.speakly.modules.user.internal.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {
}
