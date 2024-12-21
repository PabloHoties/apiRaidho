package br.com.cotiinformatica.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cotiinformatica.entities.Gestor;

public interface GestorRepository extends JpaRepository<Gestor, UUID> {

}
