package com.example.boardtest.service;

import com.example.boardtest.domain.Board;
import com.example.boardtest.repository.BoardRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BoardServiceTest {
    @Autowired BoardService boardService;
    @Autowired BoardRepository boardRepository;

    @Test
    void 글작성(){
        Board board = new Board();
        board.setTitle("title");
        //board.setContent("content");

        boardService.boardSave(board);
    }
}
