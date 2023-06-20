package com.project.sso.service;

import com.project.sso.model.Board;
import com.project.sso.model.User;
import com.project.sso.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;

    @Transactional
    public void write(Board board, User user){
        board.setCount(0);
        board.setUser(user);
        boardRepository.save(board);
    }

    @Transactional(readOnly = true)
    public Page<Board> list(Pageable pageable){
        return boardRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public Board details(int id){
        return boardRepository.findById(id)
                .orElseThrow(()->{
                    return new IllegalArgumentException("글 상세보기 실패: 아이디 찾기 실패");
                });
    }

    @Transactional
    public void delete(int id){
        boardRepository.deleteById(id);
    }

    public void edit(int id, Board requestBoard){
        Board board = boardRepository.findById(id)
        .orElseThrow(()->{
            return new IllegalArgumentException("글 찾기 실패: 아이디 찾기 실패");
        });
        board.setTitle(requestBoard.getTitle());
        board.setContent(requestBoard.getContent());
    }
}
