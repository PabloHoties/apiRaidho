package br.com.cotiinformatica.interfaces;

import java.util.UUID;

import br.com.cotiinformatica.dtos.GestorRequest;
import br.com.cotiinformatica.dtos.GestorResponse;

public interface GestorDomainService {

	GestorResponse cadastrar(GestorRequest request);
	GestorResponse consultarPorId(UUID id);
	GestorResponse autenticar(GestorRequest request);
}
