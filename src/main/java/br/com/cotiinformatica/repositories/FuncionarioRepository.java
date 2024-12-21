package br.com.cotiinformatica.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.cotiinformatica.entities.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, UUID> {

	@Query("select fu from Funcionario fu where fu.email = :pEmail and fu.senha = :pSenha")
	Funcionario findByEmailAndSenha(@Param("pEmail") String email, @Param("pSenha") String senha);
}
