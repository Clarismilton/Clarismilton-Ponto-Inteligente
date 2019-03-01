package br.com.clarismilton.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import br.com.clarismilton.entities.FuncionarioEntity;

@Transactional(readOnly = true)
public interface FuncionarioRepository extends JpaRepository<FuncionarioEntity, Long> {
	
	FuncionarioEntity findByCpf(String cpf);
	
	FuncionarioEntity findByEmail(String email);
	
	FuncionarioEntity findByCpfOrEmail(String cpf, String email);
	
}