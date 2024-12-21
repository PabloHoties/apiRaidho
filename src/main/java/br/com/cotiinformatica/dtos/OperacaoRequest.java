package br.com.cotiinformatica.dtos;

import java.util.UUID;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class OperacaoRequest {
	
	@NotNull(message = "Informe o ID do funcionário.")
	private UUID funcionario_id;
	
	@NotEmpty(message = "Informe a operação realizada.")
	private String operacao;
	
	@NotEmpty(message = "Informe a latitude atual.")
	private String latitude;
	
	@NotEmpty(message = "Informe a longitude atual.")
	private String longitude;
}
