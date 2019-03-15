package br.com.clarismilton.services.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.clarismilton.entities.LancamentoEntity;
import br.com.clarismilton.repositories.LancamentoRepository;
import br.com.clarismilton.services.LancamentoService;

@Service
public class LancamentoServiceImpl implements LancamentoService {
	
	private static final Logger log = LoggerFactory.getLogger(LancamentoServiceImpl.class);
	
	@Autowired
	private LancamentoRepository lancamentoRepository;

	public Page<LancamentoEntity> buscarPorFuncionarioId(Long funcionarioId, PageRequest pageRequest) {
		log.info("Buscando lançamentos para o funcionário ID {}", funcionarioId);
		return this.lancamentoRepository.findByFuncionarioId(funcionarioId, pageRequest);
	}

	public Optional<LancamentoEntity> buscarPorId(Long id) {
		log.info("Buscando um lançamento pelo ID {}", id);
		return Optional.ofNullable(this.lancamentoRepository.findOne(id));
	}

	public LancamentoEntity persistir(LancamentoEntity lancamento) {
		log.info("Persistindo o lancamento: {}", lancamento);
		return this.lancamentoRepository.save(lancamento);
	}

	public void remover(Long id) {
		log.info("Removendo o lançamento ID {}", id);
		this.lancamentoRepository.delete(id);
	}
	
	

}
