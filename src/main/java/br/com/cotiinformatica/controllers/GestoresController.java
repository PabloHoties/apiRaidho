package br.com.cotiinformatica.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cotiinformatica.dtos.AutenticarGestorRequest;
import br.com.cotiinformatica.dtos.AutenticarGestorResponse;
import br.com.cotiinformatica.dtos.GestorRequest;
import br.com.cotiinformatica.dtos.GestorResponse;
import br.com.cotiinformatica.interfaces.GestorDomainService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/gestores")
public class GestoresController {

	@Autowired
	private GestorDomainService gestorDomainService;
	
	
	@PostMapping("cadastrar")
	public ResponseEntity<GestorResponse> post(@RequestBody @Valid GestorRequest request) throws Exception {
		return ResponseEntity.status(201).body(gestorDomainService.cadastrar(request));
	}
	
	@GetMapping("obter/{id}")
	public ResponseEntity<GestorResponse> getById(@PathVariable UUID id) throws Exception {
		return ResponseEntity.status(200).body(gestorDomainService.consultarPorId(id));
	}
	
	@PostMapping("autenticar")
	public ResponseEntity<AutenticarGestorResponse> auth(@RequestBody @Valid AutenticarGestorRequest request) throws Exception {
		return ResponseEntity.status(200).body(gestorDomainService.autenticar(request));
	}
}
