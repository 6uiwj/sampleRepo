package com.example.boardDemo.infrastructure.repository;

import com.example.boardDemo.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardJpaRepository extends JpaRepository<Board, Integer> {
}
