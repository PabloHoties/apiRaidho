package br.com.cotiinformatica.services;

import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cotiinformatica.dtos.AutenticarFuncionarioRequest;
import br.com.cotiinformatica.dtos.AutenticarFuncionarioResponse;
import br.com.cotiinformatica.dtos.FuncionarioRequest;
import br.com.cotiinformatica.dtos.FuncionarioResponse;
import br.com.cotiinformatica.entities.Funcionario;
import br.com.cotiinformatica.interfaces.FuncionarioDomainService;
import br.com.cotiinformatica.repositories.FuncionarioRepository;

@Service
public class FuncionarioDomainServiceImpl implements FuncionarioDomainService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public FuncionarioResponse cadastrar(FuncionarioRequest request) {

		Funcionario funcionario = modelMapper.map(request, Funcionario.class);
		funcionario.setId(UUID.randomUUID());

		funcionarioRepository.save(funcionario);

		return modelMapper.map(funcionario, FuncionarioResponse.class);
	}

	@Override
	public FuncionarioResponse consultarPorId(UUID id) {

		Funcionario funcionario = funcionarioRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("O ID informado não foi encontrado."));

		return modelMapper.map(funcionario, FuncionarioResponse.class);
	}

	@Override
	public List<FuncionarioResponse> consultar() {
		
		List<Funcionario> funcionarios = funcionarioRepository.findAll();
		
		return modelMapper.map
				(funcionarios, new TypeToken
						<List<FuncionarioResponse>>() {}.getType());
	}

	@Override
	public AutenticarFuncionarioResponse autenticar(AutenticarFuncionarioRequest request) {
		
		Funcionario funcionario = funcionarioRepository.findByEmailAndSenha(request.getEmail(), request.getSenha());
		
		if (funcionario != null) {
			return modelMapper.map(funcionario, AutenticarFuncionarioResponse.class);
		} else {
			throw new IllegalArgumentException("Email ou senha informados estão inválidos. Por favor, tente novamente.");
		}
	}

}
