package com.example.boardtest.service;

import com.example.boardtest.domain.Member;
import com.example.boardtest.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    public void setMember(Member member){
        memberRepository.save(member);
    }
}
