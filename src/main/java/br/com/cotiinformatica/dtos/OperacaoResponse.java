package br.com.cotiinformatica.dtos;

import lombok.Data;

@Data
public class OperacaoResponse {

	private String operacao;
	private String latitude;
	private String longitude;
}
