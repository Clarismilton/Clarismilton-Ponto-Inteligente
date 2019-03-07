package br.com.clarismilton.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import br.com.clarismilton.entities.LancamentoEntity;

public interface LancamentoService {

	/**
	 * Retorna uma lista paginada de lançamentos de um determinado funcionário.
	 * 
	 * @param funcionarioId
	 * @param pageRequest
	 * @return Page<Lancamento>
	 */
	Page<LancamentoEntity> buscarPorFuncionarioId(Long funcionarioId, PageRequest pageRequest);
	
	/**
	 * Retorna um lançamento por ID.
	 * 
	 * @param id
	 * @return Optional<Lancamento>
	 */
	Optional<LancamentoEntity> buscarPorId(Long id);
	
	/**
	 * Persiste um lançamento na base de dados.
	 * 
	 * @param lancamento
	 * @return Lancamento
	 */
	LancamentoEntity persistir(LancamentoEntity lancamento);
	
	/**
	 * Remove um lançamento da base de dados.
	 * 
	 * @param id
	 */
	void remover(Long id);
	
}
