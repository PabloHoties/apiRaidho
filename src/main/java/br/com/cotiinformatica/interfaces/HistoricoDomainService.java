package br.com.cotiinformatica.interfaces;

import java.util.List;
import java.util.UUID;

import br.com.cotiinformatica.dtos.HistoricoRequest;
import br.com.cotiinformatica.dtos.HistoricoResponse;

public interface HistoricoDomainService {

	HistoricoResponse cadastrar(HistoricoRequest request);
	List<HistoricoResponse> consultar();
	List<HistoricoResponse> consultarPorIdDeFuncionario(UUID funcionario_id);
	List<HistoricoResponse> consultarPorIdDeFuncionarioHoje(UUID funcionario_id);
}
