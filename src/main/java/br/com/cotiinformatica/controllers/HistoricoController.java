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

import br.com.cotiinformatica.dtos.HistoricoRequest;
import br.com.cotiinformatica.dtos.HistoricoResponse;
import br.com.cotiinformatica.interfaces.HistoricoDomainService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/historico")
public class HistoricoController {
	
	@Autowired
	private HistoricoDomainService historicoDomainService;

	@PostMapping
	public ResponseEntity<HistoricoResponse> post(@RequestBody @Valid HistoricoRequest request) throws Exception {
		return ResponseEntity.status(201).body(historicoDomainService.cadastrar(request));
	}
	
	@GetMapping("consultar")
	public ResponseEntity<List<HistoricoResponse>> getAll() throws Exception {
		return ResponseEntity.status(200).body(historicoDomainService.consultar());
	}
	
	@GetMapping("obterPorIdDeFuncionario/{funcionario_id}")
	public ResponseEntity<List<HistoricoResponse>> getByIdDeFuncionario(@PathVariable UUID funcionario_id) throws Exception {
		return ResponseEntity.status(200).body(historicoDomainService.consultarPorIdDeFuncionario(funcionario_id));
	}
	
	@GetMapping("obterPorIdDeFuncionarioHoje/{funcionario_id}")
	public ResponseEntity<List<HistoricoResponse>> getByIdDeFuncionarioHoje(@PathVariable UUID funcionario_id) throws Exception {
		return ResponseEntity.status(200).body(historicoDomainService.consultarPorIdDeFuncionarioHoje(funcionario_id));
	}
}
