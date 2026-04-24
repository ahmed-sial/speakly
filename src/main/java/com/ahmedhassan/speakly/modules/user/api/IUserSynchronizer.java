package com.ahmedhassan.speakly.modules.user.api;

import org.springframework.security.oauth2.jwt.Jwt;

public interface IUserSynchronizer {
    void synchronize(Jwt token);
}
