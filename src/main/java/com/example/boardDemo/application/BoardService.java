package com.example.boardDemo.application;

import com.example.boardDemo.application.dto.request.BoardCreateDto;
import com.example.boardDemo.application.dto.response.BoardResponseDto;
import com.example.boardDemo.domain.Board;
import com.example.boardDemo.domain.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public BoardResponseDto createBoard(BoardCreateDto createDto) {
        Board board = Board.create(createDto.boardName(), createDto.content());
        board = boardRepository.save(board);
        BoardResponseDto responseDto = new BoardResponseDto(
                board.getBoardName(),
                board.getContent(),
                board.getAuthor(),
                board.getModifiedAt()
        );
        return responseDto;
    }

    public List<BoardResponseDto> getBoards() {
        List<Board> boardList = boardRepository.findAll();
        return boardList.stream()
                .map(b -> new BoardResponseDto(
                        b.getBoardName(),
                        b.getContent(),
                        b.getAuthor(),
                        b.getModifiedAt()
                ))
                .toList();
    }
}
