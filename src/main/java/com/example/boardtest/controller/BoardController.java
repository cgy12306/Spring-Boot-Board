package com.example.boardtest.controller;

import com.example.boardtest.domain.Board;
import com.example.boardtest.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Slf4j
@Controller
public class BoardController {
    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/")
    public String boardForm(){
        return "index";
    }

    @GetMapping("/board")
    public String boardList(Model model){
        List<Board> boards = boardService.findBoards();

        model.addAttribute("boards", boards);
        return "board/list";
    }

    @PostMapping("/board")
    public String boardCreate(Board board){
        log.info(board.toString());
        boardService.boardSave(board);
        return "redirect:/board/list";
    }

    @DeleteMapping("/board")
    public String boardDelete(Long bid){
        boardService.boardDelete(bid);
        return "redirect:/board";
    }

    @PutMapping("/board")
    public String boardUpdate(Board board, Long bid){
        log.info(board.toString());
        boardService.boardUpdate(board);
        return "redirect:/board";
    }

    @GetMapping("/board/create")
    public String createForm(){
        return "board/create";
    }

    @GetMapping("/board/read")
    public String boardRead(Model model, Long bid){
        Optional<Board> board = boardService.getOneBoard(bid);
        model.addAttribute("board", board.get());
        return "board/read";
    }

    @GetMapping("/board/update")
    public String boardUpdate(Model model, Long bid){
        Optional<Board> board = boardService.getOneBoard(bid);
        model.addAttribute("board", board.get());

        return "board/update";
    }
}
