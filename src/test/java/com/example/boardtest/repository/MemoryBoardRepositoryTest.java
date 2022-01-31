package com.example.boardtest.repository;

import com.example.boardtest.domain.Board;
import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class MemoryBoardRepositoryTest {
    MemoryBoardRepository repository = new MemoryBoardRepository();

    @Test
    @Commit
    public void 저장(){
        Board board = new Board();

        board.setTitle("title");
       // board.setContent("content");

        repository.save(board);

    }
}
