package br.com.clarismilton.security.services;

import java.util.Optional;

import br.com.clarismilton.entities.FuncionarioEntity;

public interface UsuarioService {

	/**
	 * Busca e retorna um usuário dado um email.
	 * 
	 * @param email
	 * @return Optional<Usuario>
	 */
	Optional<FuncionarioEntity> buscarPorEmail(String email);

}
