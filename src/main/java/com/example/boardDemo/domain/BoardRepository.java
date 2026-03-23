package com.example.boardDemo.domain;


import java.util.List;

public interface BoardRepository {
    Board save(Board board);
    List<Board> findAll();
}
