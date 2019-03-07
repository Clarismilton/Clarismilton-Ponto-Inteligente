package br.com.clarismilton.services.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.clarismilton.entities.FuncionarioEntity;
import br.com.clarismilton.repositories.FuncionarioRepository;
import br.com.clarismilton.services.FuncionarioService;

public class FuncionarioServiceImpl implements FuncionarioService {
	
	private static final Logger log = LoggerFactory.getLogger(FuncionarioServiceImpl.class);
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@Override
	public FuncionarioEntity persistir(FuncionarioEntity funcionario) {
		log.info("Persistindo funcionário: {}", funcionario);
		return this.funcionarioRepository.save(funcionario);
	}

	@Override
	public Optional<FuncionarioEntity> buscarPorCpf(String cpf) {
		log.info("Buscando funcionário pelo CPF {}", cpf);
		return Optional.ofNullable(this.funcionarioRepository.findByCpf(cpf));
	}

	@Override
	public Optional<FuncionarioEntity> buscarPorEmail(String email) {
		log.info("Buscando funcionário pelo Email {}", email);
		return Optional.ofNullable(this.funcionarioRepository.findByEmail(email));
	}

	@Override
	public Optional<FuncionarioEntity> buscarPorId(Long id) {
		log.info("Buscando funcionário pelo ID {}", id);
		return Optional.ofNullable(this.funcionarioRepository.findOne(id));
	}
	
}
