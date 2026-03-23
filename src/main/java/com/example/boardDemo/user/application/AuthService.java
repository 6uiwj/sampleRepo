package com.example.boardDemo.user.application;

import com.example.boardDemo.user.application.dto.request.LoginRequest;
import com.example.boardDemo.user.application.dto.request.SignUpRequest;
import com.example.boardDemo.user.application.dto.response.AuthResponse;
import com.example.boardDemo.user.domain.User;
import com.example.boardDemo.user.domain.UserRepository;
import com.example.boardDemo.user.infrastructure.security.CustomUserDetailsService;
import com.example.boardDemo.user.infrastructure.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final CustomUserDetailsService customUserDetailsService;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    public void signUp(SignUpRequest request) {
        if (userRepository.existsByUsername(request.username())) {
            throw new IllegalArgumentException("이미 존재하는 username입니다.");
        }

        String encodedPassword = passwordEncoder.encode(request.password());
        User user = User.create(request.username(), encodedPassword);
        userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public AuthResponse login(LoginRequest request) {
        UserDetails userDetails = customUserDetailsService.loadUserByUsername(request.username());
        if (!passwordEncoder.matches(request.password(), userDetails.getPassword())) {
            throw new BadCredentialsException("아이디 또는 비밀번호가 올바르지 않습니다.");
        }

        String token = jwtTokenProvider.generateToken(userDetails);
        return new AuthResponse(token);
    }
}
