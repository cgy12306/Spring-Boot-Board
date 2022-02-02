package com.example.boardtest.repository;

import com.example.boardtest.domain.Board;

import java.util.List;
import java.util.Optional;


public interface BoardRepository {
    Board save(Board board);
    List<Board> findAll();
    Optional<Board> findById(Long bid);
    int deleteById(Long bid);
    void updateById(Board board);
}
