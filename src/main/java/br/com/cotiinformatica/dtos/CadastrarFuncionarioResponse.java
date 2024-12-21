package br.com.cotiinformatica.dtos;

import lombok.Data;

@Data
public class CadastrarFuncionarioResponse {

	private String nome;
	private String email;
	private String senha;
}
