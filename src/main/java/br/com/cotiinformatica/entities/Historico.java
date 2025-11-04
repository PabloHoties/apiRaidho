package br.com.cotiinformatica.entities;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "historico")
public class Historico {

	@Id
	@Column(name = "id")
	private UUID id;
	
	@ManyToOne
	@JoinColumn(name = "funcionario_id", nullable = false)
	private Funcionario funcionario;
	
	@Column(name = "operacao", length = 100, nullable = false)
	private Operacao operacao;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_hora_operacao", nullable = false)
	private Date dataHoraOperacao;
	
	@Column(name = "latitude", length = 100, nullable = false)
	private String latitude;
	
	@Column(name = "longitude", length = 100, nullable = false)
	private String longitude;
}
