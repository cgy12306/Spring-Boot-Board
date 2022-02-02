package com.example.boardtest.repository;

import com.example.boardtest.domain.Board;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

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

    @Override
    public Optional<Board> findById(Long bid) {
        Board board = em.find(Board.class, bid);
        return Optional.ofNullable(board);
    }

    @Override
    public int deleteById(Long bid) {
        return em.createQuery("delete from Board b where b.bid=:bid")
                .setParameter("bid", bid)
                .executeUpdate();
    }

    @Override
    public void updateById(Board board) {
        em.createQuery("update Board b set b.content=:content, b.title=:title where b.bid=:bid")
                .setParameter("content", board.getContent())
                .setParameter("title", board.getTitle())
                .setParameter("bid", board.getBid())
                .executeUpdate();
    }
}
