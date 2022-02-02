package com.example.boardtest.controller;

import com.example.boardtest.domain.Member;
import com.example.boardtest.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class MemberController {
    private MemberService memberService;
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/register")
    public String memberRegister(){
        return "member/register";
    }

    @PostMapping("/register")
    public String memberSave(Member member){
        log.info(member.toString());
        memberService.setMember(member);
        log.info("complete save");
        return "redirect:/";
    }
}
