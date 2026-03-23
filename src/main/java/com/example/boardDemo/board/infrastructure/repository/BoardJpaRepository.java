package com.example.boardDemo.board.infrastructure.repository;

import com.example.boardDemo.board.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardJpaRepository extends JpaRepository<Board, Integer> {
}
