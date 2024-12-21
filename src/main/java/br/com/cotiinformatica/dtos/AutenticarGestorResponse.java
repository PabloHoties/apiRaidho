package br.com.cotiinformatica.dtos;

import java.util.UUID;

import lombok.Data;

@Data
public class AutenticarGestorResponse {

	private UUID id;
	private String nome;
	private String email;
	private String senha;
}
