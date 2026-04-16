package com.ahmedhassan.speakly.modules.user.internal.domain;

public interface UserRepository {
    User findById(UserId userId);
    User findByEmail(String email);
    boolean emailExists(String email);
    User save(User user);
    User update(UserId userId, User user);
    void delete(UserId userId);
}
