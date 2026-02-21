package com.example.security.oauth.service;

import com.agstech.security.oauth.model.User;
import com.agstech.security.oauth.repository.UserRepository;
import com.agstech.security.oauth.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserService userService;

    @Test
    void save() {
        User user = new User();
        user.setUsername("testuser");
        user.setPassword("password");

        when(passwordEncoder.encode("password")).thenReturn("encodedPassword");

        userService.save(user);

        verify(userRepository).save(user);
        verify(passwordEncoder).encode("password");
    }
}
