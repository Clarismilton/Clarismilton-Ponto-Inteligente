package br.com.clarismilton.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import br.com.clarismilton.entities.EmpresaEntity;

public interface EmpresaRepository extends JpaRepository<EmpresaEntity, Long> {

	@Transactional(readOnly = true)
	EmpresaEntity findByCnpj(String cnpj);
	
}
