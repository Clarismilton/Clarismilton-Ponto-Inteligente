package br.com.clarismilton.services;

import java.util.Optional;

import br.com.clarismilton.entities.FuncionarioEntity;

public interface FuncionarioService {
	
	 /**
	  * 
	  * Cadastra um novo funcionario na base de dados.
	  * 
	  * @param funcionario
	  * @return funcionario
	  * 
	  **/
	 FuncionarioEntity persistir(FuncionarioEntity funcionario);
	 
	/**
	 * Busca e retorna um funcionario dado um CPF
	 * 
	 * @param cpf
	 * @return Optional<Funcionario>
	 * 
	 */
	 Optional<FuncionarioEntity> buscarPorCpf(String cpf);
	 
	/**
	 * Busca e retorna um funcionario dado um email.
	 * 
	 * @param email
	 * @return Optional<Funcionario>
	 * 
	 */
	 Optional<FuncionarioEntity> buscarPorEmail(String email);
	 
	/**
	 * Busca e retorna um funcionario por ID.
	 *  
	 * @param id
	 * @return Optional<Funcionario>
	 * 
	 */
	 Optional<FuncionarioEntity> buscarPorId(Long id);
	 
}
