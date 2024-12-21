package br.com.cotiinformatica.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cotiinformatica.dtos.CadastrarFuncionarioRequest;
import br.com.cotiinformatica.dtos.FuncionarioResponse;

@RestController
@RequestMapping("/api/funcionarios")
public class FuncionariosController {

	@PostMapping
	public ResponseEntity<FuncionarioResponse> post(CadastrarFuncionarioRequest request) throws Exception {
		return null;
	}
	
	@GetMapping("obter/{id}")
	public ResponseEntity<FuncionarioResponse> getById(@PathVariable UUID id) throws Exception {
		return null;
	}
	
	@GetMapping("consultar")
	public ResponseEntity<List<FuncionarioResponse>> getAll(UUID id) throws Exception {
		return null;
	}
}
