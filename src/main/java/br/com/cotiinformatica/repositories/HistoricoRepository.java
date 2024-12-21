package br.com.cotiinformatica.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.cotiinformatica.entities.Historico;

@Repository
public interface HistoricoRepository extends JpaRepository<Historico, UUID> {

	@Query("select hi from Historico hi where hi.funcionario.id = :funcionario_id")
	List<Historico> findByHistoricoPorIdDeFuncionario(UUID funcionario_id);

	@Query("select hi from Historico hi where hi.funcionario.id = :funcionario_id and FUNCTION('DATE', hi.dataHoraOperacao) = CURRENT_DATE")
	List<Historico> findByHistoricoPorIdDeFuncionarioHoje(UUID funcionario_id);
}
