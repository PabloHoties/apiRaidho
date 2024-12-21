package br.com.cotiinformatica.interfaces;

import java.util.List;
import java.util.UUID;

import br.com.cotiinformatica.dtos.FuncionarioRequest;
import br.com.cotiinformatica.dtos.FuncionarioResponse;

public interface FuncionarioDomainService {

	FuncionarioResponse cadastrar(FuncionarioRequest request);
	FuncionarioResponse consultarPorId(UUID id);
	List<FuncionarioResponse> consultar();
	FuncionarioResponse autenticar(FuncionarioRequest request);
}
