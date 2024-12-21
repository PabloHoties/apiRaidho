package br.com.cotiinformatica.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.cotiinformatica.entities.Gestor;

@Repository
public interface GestorRepository extends JpaRepository<Gestor, UUID> {

	@Query("select us from Gestor us where us.email = :pEmail and us.senha = :pSenha")
	Gestor findByEmailAndSenha(@Param("pEmail") String email, @Param("pSenha") String senha);
}
