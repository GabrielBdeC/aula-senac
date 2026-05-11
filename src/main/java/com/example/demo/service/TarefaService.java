package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Tarefa;
import com.example.demo.repository.TarefaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TarefaService {

	private final TarefaRepository tarefaRepository;

	public List<Tarefa> listarTodas() {
		return tarefaRepository.findAllByOrderByIdDesc();
	}

	public void salvar(String titulo) {
		if (titulo == null || titulo.isBlank()) {
			return;
		}

		Tarefa tarefa = new Tarefa();
		tarefa.setTitulo(titulo.trim());
		tarefa.setConcluida(false);

		tarefaRepository.save(tarefa);
	}

	public void concluir(Long id) {
		Tarefa tarefa = tarefaRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Tarefa nao encontrada: " + id));

		tarefa.setConcluida(true);
		tarefa.setDataConclusao(LocalDate.now());

		tarefaRepository.save(tarefa);
	}

	public void excluir(Long id) {
		tarefaRepository.deleteById(id);
	}
}
