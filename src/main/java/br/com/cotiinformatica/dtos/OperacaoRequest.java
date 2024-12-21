package br.com.cotiinformatica.dtos;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class OperacaoRequest {
	
	@NotEmpty(message = "Informe a operação realizada.")
	private String operacao;
	
	@NotEmpty(message = "Informe a latitude atual.")
	private String latitude;
	
	@NotEmpty(message = "Informe a longitude atual.")
	private String longitude;
}
