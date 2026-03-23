package com.example.boardDemo.application.dto.response;

import com.example.boardDemo.domain.Board;

import java.time.LocalDateTime;

public record BoardResponseDto (
        String boardName,
        String content,
        String author,
        LocalDateTime modifiedAt
){

}
