package br.com.clarismilton.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import br.com.clarismilton.entities.FuncionarioEntity;

@Transactional(readOnly = true)
public interface UsuarioRepository extends JpaRepository<FuncionarioEntity, Long> {
	FuncionarioEntity findByEmail(String email);
}
