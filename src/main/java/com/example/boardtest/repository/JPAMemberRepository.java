package com.example.boardtest.repository;

import com.example.boardtest.domain.Member;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;

@Slf4j
public class JPAMemberRepository implements MemberRepository {
    private EntityManager em;

    public JPAMemberRepository(EntityManager em) {
        this.em = em;
    }
    @Override
    public Member save(Member member){
        log.info(member.toString());
        em.persist(member);
        return member;
    }
}
