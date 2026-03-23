package com.example.boardDemo.user.application.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record SignUpRequest(
        @NotBlank(message = "username은 필수입니다.")
        @Size(min = 4, max = 20, message = "username은 4~20자여야 합니다.")
        String username,
        @NotBlank(message = "password는 필수입니다.")
        @Size(min = 8, max = 100, message = "password는 8자 이상이어야 합니다.")
        String password
) {
}
