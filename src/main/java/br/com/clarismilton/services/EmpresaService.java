package br.com.clarismilton.services;

import java.util.Optional;

import br.com.clarismilton.entities.EmpresaEntity;

public interface EmpresaService {
	
	/**
	 * Retorna uma empresa dado um CNPJ
	 * 
	 * @param cnpj
	 * @return Optional<Empresa>
	 * 
	 */
	 Optional<EmpresaEntity> buscarPorCnpj(String cnpj);
	 
	 /**
	  * 
	  * Cadastra uma nova empresa na base de dados.
	  * 
	  * @param empresa
	  * @return Empresa
	  * 
	  **/
	 EmpresaEntity persistir(EmpresaEntity empresa);
	 
}
