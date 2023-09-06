package org.nikita.arcadeera.controller;

import org.nikita.arcadeera.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserControllerImpl implements UserController {
    private final UserService userService;

    @Autowired
    public  UserControllerImpl(UserService userService) {
        this.userService = userService;
    }

    // Реализация методов контроллера
}
