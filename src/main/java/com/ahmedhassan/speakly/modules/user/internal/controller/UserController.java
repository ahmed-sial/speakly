package com.ahmedhassan.speakly.modules.user.internal.controller;

import com.ahmedhassan.speakly.modules.user.api.IUserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final IUserFacade userFacade;
}
