package br.com.cotiinformatica.interfaces;

import java.util.UUID;

import br.com.cotiinformatica.dtos.AutenticarGestorRequest;
import br.com.cotiinformatica.dtos.AutenticarGestorResponse;
import br.com.cotiinformatica.dtos.GestorRequest;
import br.com.cotiinformatica.dtos.GestorResponse;

public interface GestorDomainService {

	GestorResponse cadastrar(GestorRequest request);
	GestorResponse consultarPorId(UUID id);
	AutenticarGestorResponse autenticar(AutenticarGestorRequest request);
}
