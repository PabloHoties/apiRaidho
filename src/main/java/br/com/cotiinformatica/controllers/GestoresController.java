package br.com.cotiinformatica.controllers;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cotiinformatica.dtos.GestorRequest;
import br.com.cotiinformatica.dtos.GestorResponse;

@RestController
@RequestMapping("/api/gestores")
public class GestoresController {

	
	@PostMapping("cadastrar")
	public ResponseEntity<GestorResponse> post(GestorRequest request) throws Exception {
		return null;
	}
	
	@GetMapping("obter/{id}")
	public ResponseEntity<GestorResponse> getById(@PathVariable UUID id) throws Exception {
		return null;
	}
	
	@PostMapping("autenticar")
	public ResponseEntity<GestorResponse> auth(GestorRequest request) throws Exception {
		return null;
	}
}
