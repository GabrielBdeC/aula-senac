package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.TarefaService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TarefaController {

	private final TarefaService tarefaService;

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("tarefas", tarefaService.listarTodas());
		return "index";
	}

	@PostMapping("/tarefas")
	public String salvar(@RequestParam String titulo) {
		tarefaService.salvar(titulo);
		return "redirect:/";
	}

	@PutMapping("/tarefas/{id}/concluir")
	public String concluir(@PathVariable Long id) {
		tarefaService.concluir(id);
		return "redirect:/";
	}

	@DeleteMapping("/tarefas/{id}")
	public String excluir(@PathVariable Long id) {
		tarefaService.excluir(id);
		return "redirect:/";
	}
}
