package br.com.cotiinformatica.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class GestorRequest {

	@NotEmpty(message = "Informe o nome do funcionário.")
	@Size(min = 8, max = 100, message = "Infomre um nome com no mínimo 8 caracteres.")
	private String nome;

	@Email(message = "Informe um email válido.")
	@NotEmpty(message = "Informe o email do funcionário")
	private String email;

	@NotEmpty(message = "Informe a senha do funcionário")
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$", 
	message = "Por favor, informe a senha com letras minúsculas, números, símbolos e pelo menos 8 caracteres.")
	private String senha;
}
