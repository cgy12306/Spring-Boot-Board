package com.example.boardtest.repository;

import com.example.boardtest.domain.Board;

import java.util.List;


public interface BoardRepository {
    Board save(Board board);
    List<Board> findAll();
}
