package br.com.cotiinformatica.services;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cotiinformatica.dtos.AutenticarGestorRequest;
import br.com.cotiinformatica.dtos.AutenticarGestorResponse;
import br.com.cotiinformatica.dtos.GestorRequest;
import br.com.cotiinformatica.dtos.GestorResponse;
import br.com.cotiinformatica.entities.Gestor;
import br.com.cotiinformatica.interfaces.GestorDomainService;
import br.com.cotiinformatica.repositories.GestorRepository;

@Service
public class GestorDomainServiceImpl implements GestorDomainService {

	@Autowired
	private GestorRepository gestorRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public GestorResponse cadastrar(GestorRequest request) {

		Gestor gestor = modelMapper.map(request, Gestor.class);
		gestor.setId(UUID.randomUUID());

		gestorRepository.save(gestor);

		return modelMapper.map(gestor, GestorResponse.class);
	}

	@Override
	public GestorResponse consultarPorId(UUID id) {

		Gestor gestor = gestorRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("O ID informado não foi encontrado."));

		return modelMapper.map(gestor, GestorResponse.class);
	}

	@Override
	public AutenticarGestorResponse autenticar(AutenticarGestorRequest request) {

		Gestor gestor = gestorRepository.findByEmailAndSenha(request.getEmail(), request.getSenha());

		if (gestor != null) {

			return modelMapper.map(gestor, AutenticarGestorResponse.class);
		} else {
			throw new IllegalArgumentException(
					"Email ou senha informados estão inválidos. Por favor, tente novamente.");
		}
	}

}
