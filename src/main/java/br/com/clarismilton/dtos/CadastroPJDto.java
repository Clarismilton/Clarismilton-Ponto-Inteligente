package br.com.clarismilton.dtos;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

public class CadastroPJDto {
	
	private Long id;
	private String nome;
	private String email;
	private String senha;
	private String cpf;
	private String razaoSocial;
	private String cnpj;
	
	public CadastroPJDto() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@NotEmpty(message = "Nome não pode ser em branco...")
	@Length(min = 3, max = 200, message = "Nome deve conter entre 3 e 200 caracteres...")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@NotEmpty(message = "Email não pode ser em branco...")
	@Length(min = 5, max = 200, message = "Email deve conter entre 5 e 200 caracteres...")
	@Email(message = "Email inválido...")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@NotEmpty(message = "Senha não pode ser em branco...")
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@NotEmpty(message = "CPF não pode ser em branco...")
	@CPF(message = "CPF Inválido...")
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@NotEmpty(message = "Razão social não pode ser em branco...")
	@Length(min = 5, max = 200, message = "Razão social deve conter entre 5 e 200 caracteres...")
	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	@NotEmpty(message = "CNPJ não pde ser em branco...")
	@CNPJ(message = "CNPJ Inválido...")
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	@Override
	public String toString() {
		return "CadastroPJDto [id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + ", cpf=" + cpf
				+ ", razaoSocial=" + razaoSocial + ", cnpj=" + cnpj + "]";
	}
	
}