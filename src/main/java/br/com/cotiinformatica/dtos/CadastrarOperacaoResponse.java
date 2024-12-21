package br.com.cotiinformatica.dtos;

import lombok.Data;

@Data
public class CadastrarOperacaoResponse {

	private String operacao;
	private String latitude;
	private String longitude;
}
