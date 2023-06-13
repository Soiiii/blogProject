package com.project.sso.repository;

import com.project.sso.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository <Board, Integer>{
}
