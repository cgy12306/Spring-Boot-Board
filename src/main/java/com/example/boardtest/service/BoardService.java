package com.example.boardtest.service;

import com.example.boardtest.domain.Board;
import com.example.boardtest.repository.BoardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class BoardService {
    private final BoardRepository boardRepository;
    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public void boardSave(Board board){
        boardRepository.save(board);
    }
    public List<Board> findBoards(){
        return boardRepository.findAll();
    }
}
