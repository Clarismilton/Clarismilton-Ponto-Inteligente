package br.com.clarismilton.repositories;

import java.util.List;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import br.com.clarismilton.entities.LancamentoEntity;

@Transactional(readOnly = true)
@NamedQueries({
		@NamedQuery(name = "LancamentoRepository.findByFuncionarioId", 
				query = "SELECT lanc FROM Lancamento lanc WHERE lanc.funcionario.id = :funcionarioId") })
public interface LancamentoRepository extends JpaRepository<LancamentoEntity, Long> {

	List<LancamentoEntity> findByFuncionarioId(@Param("funcionarioId") Long funcionarioId);

	Page<LancamentoEntity> findByFuncionarioId(@Param("funcionarioId") Long funcionarioId, Pageable pageable);
}
