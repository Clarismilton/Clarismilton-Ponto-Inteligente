package br.com.clarismilton.dtos;

import java.util.Optional;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

public class CadastroPFDto {
	
	private Long id;
	private String nome;
	private String email;
	private String senha;
	private String cpf;
	private Optional<String> valorHora = Optional.empty();
	private Optional<String> qtdHorasTrabalhadasDia = Optional.empty();
	private Optional<String> qtdHorasAlmoco = Optional.empty();
	private String cnpj;
	
	public CadastroPFDto() {
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
	
	public Optional<String> getValorHora() {
		return valorHora;
	}

	public void setValorHora(Optional<String> valorHora) {
		this.valorHora = valorHora;
	}

	public Optional<String> getQtdHorasTrabalhadasDia() {
		return qtdHorasTrabalhadasDia;
	}

	public void setQtdHorasTrabalhadasDia(Optional<String> qtdHorasTrabalhadasDia) {
		this.qtdHorasTrabalhadasDia = qtdHorasTrabalhadasDia;
	}

	public Optional<String> getQtdHorasAlmoco() {
		return qtdHorasAlmoco;
	}

	public void setQtdHorasAlmoco(Optional<String> qtdHorasAlmoco) {
		this.qtdHorasAlmoco = qtdHorasAlmoco;
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
		return "CadastroPFDto [id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + ", cpf=" + cpf
				+ ", valorHora=" + valorHora + ", qtdHorasTrabalhadasDia=" + qtdHorasTrabalhadasDia
				+ ", qtdHorasAlmoco=" + qtdHorasAlmoco + ", cnpj=" + cnpj + "]";
	}
	
}
