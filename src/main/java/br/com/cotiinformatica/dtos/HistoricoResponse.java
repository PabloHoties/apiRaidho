package br.com.cotiinformatica.dtos;

import java.util.Date;
import java.util.UUID;

import lombok.Data;

@Data
public class HistoricoResponse {

	private UUID id;
	private UUID funcionario_id;
	private String operacao;
	private String latitude;
	private String longitude;
	private Date dataHoraOperacao;
}
