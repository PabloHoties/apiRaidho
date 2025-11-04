package br.com.cotiinformatica.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cotiinformatica.dtos.HistoricoRequest;
import br.com.cotiinformatica.dtos.HistoricoResponse;
import br.com.cotiinformatica.entities.Funcionario;
import br.com.cotiinformatica.entities.Historico;
import br.com.cotiinformatica.entities.Operacao;
import br.com.cotiinformatica.interfaces.HistoricoDomainService;
import br.com.cotiinformatica.repositories.FuncionarioRepository;
import br.com.cotiinformatica.repositories.HistoricoRepository;

@Service
public class HistoricoDomainServiceImpl implements HistoricoDomainService {

	@Autowired
	private HistoricoRepository historicoRepository;

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public HistoricoResponse cadastrar(HistoricoRequest request) {

		Funcionario funcionario = funcionarioRepository.findById(request.getFuncionario_id())
				.orElseThrow(() -> new IllegalArgumentException(
						"O ID informado não pertence a um funcionário cadastrado no sistema."));

		Historico historico = modelMapper.map(request, Historico.class);
		historico.setId(UUID.randomUUID());
		historico.setFuncionario(funcionario);
		historico.setOperacao(Operacao.valueOf(request.getOperacao()));
		historico.setDataHoraOperacao(new Date());

		historicoRepository.save(historico);

		HistoricoResponse response = modelMapper.map(historico, HistoricoResponse.class);
		response.setFuncionario_id(funcionario.getId());

		return response;

	}

	@Override
	public List<HistoricoResponse> consultar() {

		List<Historico> historicos = historicoRepository.findAll();

		List<HistoricoResponse> response = new ArrayList<>();

		Integer indice = 0;
		for (Historico historico : historicos) {
			HistoricoResponse historicoLoop = new HistoricoResponse();
			historicoLoop.setId(historico.getId());
			historicoLoop.setFuncionario_id(historico.getFuncionario().getId());
			historicoLoop.setOperacao(historico.getOperacao().toString());
			historicoLoop.setLatitude(historico.getLatitude());
			historicoLoop.setLongitude(historico.getLongitude());
			historicoLoop.setDataHoraOperacao(historico.getDataHoraOperacao());
			
			response.add(historicoLoop);
			indice++;
		}

		return response;
	}

	@Override
	public List<HistoricoResponse> consultarPorIdDeFuncionario(UUID funcionario_id) {

		funcionarioRepository.findById(funcionario_id)
				.orElseThrow(() -> new IllegalArgumentException("O ID informado não pertence a um funcionário cadastrado no sistema."));
		
		List<Historico> historicos = historicoRepository.findByHistoricoPorIdDeFuncionario(funcionario_id);

		List<HistoricoResponse> response = new ArrayList<>();

		Integer indice = 0;
		for (Historico historico : historicos) {
			HistoricoResponse historicoLoop = new HistoricoResponse();
			historicoLoop.setId(historico.getId());
			historicoLoop.setFuncionario_id(historico.getFuncionario().getId());
			historicoLoop.setOperacao(historico.getOperacao().toString());
			historicoLoop.setLatitude(historico.getLatitude());
			historicoLoop.setLongitude(historico.getLongitude());
			historicoLoop.setDataHoraOperacao(historico.getDataHoraOperacao());
			
			response.add(historicoLoop);
			indice++;
		}

		return response;
	}

	@Override
	public List<HistoricoResponse> consultarPorIdDeFuncionarioHoje(UUID funcionario_id) {
		
		funcionarioRepository.findById(funcionario_id)
		.orElseThrow(() -> new IllegalArgumentException("O ID informado não pertence a um funcionário cadastrado no sistema."));

		List<Historico> historicos = historicoRepository.findByHistoricoPorIdDeFuncionarioHoje(funcionario_id);

		List<HistoricoResponse> response = new ArrayList<>();

		Integer indice = 0;
		for (Historico historico : historicos) {
			HistoricoResponse historicoLoop = new HistoricoResponse();
			historicoLoop.setId(historico.getId());
			historicoLoop.setFuncionario_id(historico.getFuncionario().getId());
			historicoLoop.setOperacao(historico.getOperacao().toString());
			historicoLoop.setLatitude(historico.getLatitude());
			historicoLoop.setLongitude(historico.getLongitude());
			historicoLoop.setDataHoraOperacao(historico.getDataHoraOperacao());
			
			response.add(historicoLoop);
			indice++;
		}

		return response;
	}

}
