package org.nikita.arcadeera.service;

import org.nikita.arcadeera.converter.UserConverter;
import org.nikita.arcadeera.entity.User;
import org.nikita.arcadeera.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final UserConverter userConverter;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           UserConverter userConverter) {
        this.userRepository = userRepository;
        this.userConverter = userConverter;
    }
}
