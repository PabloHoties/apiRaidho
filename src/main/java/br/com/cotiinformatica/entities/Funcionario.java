package br.com.cotiinformatica.entities;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "funcionario")
public class Funcionario {

	@Id
	@Column(name = "id")
	private UUID id;
	
	@Column(name = "nome", length = 100, nullable = false)
	private String nome;
	
	@Column(name = "email", length = 100, nullable = false)
	private String email;
	
	@Column(name = "senha", length = 100, nullable = false)
	private String senha;
	
	@OneToMany(mappedBy = "funcionario")
	private List<Historico> historicos;
}
