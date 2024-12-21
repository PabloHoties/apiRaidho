package br.com.cotiinformatica.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cotiinformatica.dtos.OperacaoRequest;
import br.com.cotiinformatica.dtos.OperacaoResponse;

@RestController
@RequestMapping("/api/historico")
public class HistoricoController {

	@PostMapping
	public ResponseEntity<OperacaoResponse> post(OperacaoRequest request) throws Exception {
		return null;
	}
	
	@GetMapping("consultar")
	public ResponseEntity<List<OperacaoResponse>> getAll() throws Exception {
		return null;
	}
	
	@GetMapping("obter/{id}")
	public ResponseEntity<OperacaoResponse> getById(@PathVariable UUID id) throws Exception {
		return null;
	}
}
