package br.com.cotiinformatica.interfaces;

import java.util.List;
import java.util.UUID;

import br.com.cotiinformatica.dtos.OperacaoRequest;
import br.com.cotiinformatica.dtos.OperacaoResponse;

public interface HistoricoDomainService {

	OperacaoResponse cadastrar(OperacaoRequest request);
	List<OperacaoResponse> consultar();
	OperacaoResponse consultarPorId(UUID id);
}
