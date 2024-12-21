package br.com.cotiinformatica.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cotiinformatica.dtos.OperacaoResponse;

@RestController
@RequestMapping("/api/historico")
public class HistoricoController {

	@PostMapping
	public ResponseEntity<OperacaoResponse> post() throws Exception {
		return null;
	}
	
	@GetMapping("consultar")
	public ResponseEntity<List<OperacaoResponse>> getAll() throws Exception {
		return null;
	}
	
	@GetMapping("obter/{id}")
	public ResponseEntity<OperacaoResponse> getById() throws Exception {
		return null;
	}
}
