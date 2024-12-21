package br.com.cotiinformatica.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class AutenticarFuncionarioRequest {

	@Email(message = "Informe um email válido.")
	@NotEmpty(message = "Informe o email do funcionário")
	private String email;
	
	@NotEmpty(message = "Informe a senha do funcionário")
	private String senha;
}
