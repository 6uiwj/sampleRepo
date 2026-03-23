package com.example.boardDemo.presentation;

import com.example.boardDemo.application.BoardService;
import com.example.boardDemo.application.dto.request.BoardCreateDto;
import com.example.boardDemo.application.dto.response.BoardResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
