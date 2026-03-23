package com.example.boardDemo.infrastructure.repository;

import com.example.boardDemo.domain.Board;
import com.example.boardDemo.domain.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardRepositoryImpl implements BoardRepository {
    private final BoardJpaRepository boardJpaRepository;

    @Override
    public Board save(Board board) {
        return boardJpaRepository.save(board);
    }

    @Override
    public List<Board> findAll() {
        return boardJpaRepository.findAll();
    }
}
