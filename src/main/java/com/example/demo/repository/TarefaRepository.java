package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

	List<Tarefa> findAllByOrderByIdDesc();
}
