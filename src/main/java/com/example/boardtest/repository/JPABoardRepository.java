package com.example.boardtest.repository;

import com.example.boardtest.domain.Board;

import javax.persistence.EntityManager;
import java.util.List;

public class JPABoardRepository implements BoardRepository{
    private final EntityManager em;

    public JPABoardRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Board save(Board board) {
        em.persist(board);
        return board;
    }

    @Override
    public List<Board> findAll() {
        return em.createQuery("select b from Board b", Board.class).getResultList();
    }

}
