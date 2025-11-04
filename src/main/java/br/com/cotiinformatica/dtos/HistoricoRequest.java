package br.com.cotiinformatica.dtos;

import java.util.Date;
import java.util.UUID;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class HistoricoRequest {
	
	@NotNull(message = "Informe o ID do funcionário.")
	private UUID funcionario_id;
	
	@Pattern(
			regexp = "EXPEDIENTE_INICIO|ALMOÇO_INICIO|ALMOÇO_FIM|EXPEDIENTE_FIM", 
			message = "A categoria deve ser EXPEDIENTE_INICIO ou ALMOÇO_INICIO ou ALMOÇO_FIM ou EXPEDIENTE_FIM")
	@NotEmpty(message = "Informe a operação realizada.")
	private String operacao;
	
	@NotEmpty(message = "Informe a latitude atual.")
	private String latitude;
	
	@NotEmpty(message = "Informe a longitude atual.")
	private String longitude;	
}
