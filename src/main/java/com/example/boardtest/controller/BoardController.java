package com.example.boardtest.controller;

import com.example.boardtest.domain.Board;
import com.example.boardtest.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

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

    @GetMapping("/board/create")
    public String createForm(){
        return "board/create";
    }

    @PostMapping("/board/create")
    public String boardCreate(BoardForm form){
        Board board = new Board();

        board.setTitle(form.getTitle());
        board.setContent(form.getContent());

        boardService.boardSave(board);
        System.out.println("get board : " + board.getBid());
        System.out.println(board.getContent());
        return "redirect:/";
    }
    @GetMapping("/board")
    public String boardList(Model model){
        List<Board> boards = boardService.findBoards();
        model.addAttribute("boards", boards);
        return "board/list";
    }
}
