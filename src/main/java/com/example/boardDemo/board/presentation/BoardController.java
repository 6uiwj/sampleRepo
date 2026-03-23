package com.example.boardDemo.board.presentation;

import com.example.boardDemo.board.application.BoardService;
import com.example.boardDemo.board.application.dto.request.BoardCreateDto;
import com.example.boardDemo.board.application.dto.response.BoardResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @PostMapping
    public ResponseEntity<BoardResponseDto> createBoard(@RequestBody BoardCreateDto createDto) {
        BoardResponseDto responseDto = boardService.createBoard(createDto);
        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }

    @GetMapping
    public ResponseEntity<List<BoardResponseDto>> getBoards() {
        List<BoardResponseDto> responseDtoList = boardService.getBoards();
        return ResponseEntity.status(HttpStatus.OK).body(responseDtoList);
    }
}
