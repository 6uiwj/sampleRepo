package com.example.boardDemo.board.application.dto.request;

public record BoardCreateDto(
        String boardName,
        String content
) {
}
