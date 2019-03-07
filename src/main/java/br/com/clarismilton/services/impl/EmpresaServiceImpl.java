package br.com.clarismilton.services.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.clarismilton.entities.EmpresaEntity;
import br.com.clarismilton.repositories.EmpresaRepository;
import br.com.clarismilton.services.EmpresaService;

@Service
public class EmpresaServiceImpl implements EmpresaService {
	
	private static final Logger log = LoggerFactory.getLogger(EmpresaServiceImpl.class);
	
	@Autowired
	private EmpresaRepository empresaRepository;

	@Override
	public Optional<EmpresaEntity> buscarPorCnpj(String cnpj) {
		log.info("Buscando uma empresa para o CNPJ {}", cnpj);
		return Optional.ofNullable(empresaRepository.findByCnpj(cnpj));
	}

	@Override
	public EmpresaEntity persistir(EmpresaEntity empresa) {
		log.info("Persistindo empresa: {}", empresa);
		return this.empresaRepository.save(empresa);
	}	
}
