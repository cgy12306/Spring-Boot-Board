package com.example.boardtest;

import com.example.boardtest.domain.Board;
import com.example.boardtest.domain.Member;
import com.example.boardtest.repository.BoardRepository;
import com.example.boardtest.repository.JPABoardRepository;
import com.example.boardtest.repository.JPAMemberRepository;
import com.example.boardtest.repository.MemberRepository;
import com.example.boardtest.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HiddenHttpMethodFilter;

import javax.persistence.EntityManager;

@Configuration
public class SpringConfig {
    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public BoardRepository boardRepository(){
        return new JPABoardRepository(em);
    }

    @Bean
    public MemberRepository memberRepository(){
        return new JPAMemberRepository(em);
    }

    @Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilter(){
        return new HiddenHttpMethodFilter();
    }

}
