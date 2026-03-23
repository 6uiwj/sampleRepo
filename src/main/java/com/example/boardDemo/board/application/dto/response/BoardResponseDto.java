package com.example.boardDemo.board.application.dto.response;

import java.time.LocalDateTime;

public record BoardResponseDto(
        String boardName,
        String content,
        String author,
        LocalDateTime modifiedAt
) {
}
