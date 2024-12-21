package br.com.cotiinformatica.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cotiinformatica.dtos.AutenticarFuncionarioRequest;
import br.com.cotiinformatica.dtos.AutenticarFuncionarioResponse;
import br.com.cotiinformatica.dtos.FuncionarioRequest;
import br.com.cotiinformatica.dtos.FuncionarioResponse;
import br.com.cotiinformatica.interfaces.FuncionarioDomainService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/funcionarios")
public class FuncionariosController {
	
	@Autowired
	private FuncionarioDomainService funcionarioDomainService;

	@PostMapping("cadastrar")
	public ResponseEntity<FuncionarioResponse> post(@RequestBody @Valid FuncionarioRequest request) throws Exception {
		return ResponseEntity.status(201).body(funcionarioDomainService.cadastrar(request));
	}
	
	@GetMapping("obter/{id}")
	public ResponseEntity<FuncionarioResponse> getById(@PathVariable UUID id) throws Exception {
		return ResponseEntity.status(200).body(funcionarioDomainService.consultarPorId(id));
	}
	
	@GetMapping("consultar")
	public ResponseEntity<List<FuncionarioResponse>> getAll() throws Exception {
		return ResponseEntity.status(200).body(funcionarioDomainService.consultar());
	}
	
	@PostMapping("autenticar")
	public ResponseEntity<AutenticarFuncionarioResponse> auth(@RequestBody @Valid AutenticarFuncionarioRequest request) throws Exception {
		return ResponseEntity.status(200).body(funcionarioDomainService.autenticar(request));
	}
}
