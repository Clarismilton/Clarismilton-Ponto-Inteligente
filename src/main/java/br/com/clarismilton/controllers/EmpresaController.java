package br.com.clarismilton.controllers;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.clarismilton.dtos.EmpresaDto;
import br.com.clarismilton.entities.EmpresaEntity;
import br.com.clarismilton.response.Response;
import br.com.clarismilton.services.EmpresaService;

@RestController
@RequestMapping("/api/empresas")
@CrossOrigin(origins = "*") //Permite que a classe se torne acessível para múltiplos domínios.
public class EmpresaController {
	
	private static final Logger log = LoggerFactory.getLogger(EmpresaController.class);
	
	@Autowired
	private EmpresaService empresaService;
	
	public EmpresaController() {
	}

	/**
	 * Retorna uma empresa dado um CNPJ.
	 * 
	 * @param cnpj
	 * @return ResponseEntity<Response<EmpresaDto>>
	 * */
	@GetMapping(value = "/cnpj/{cnpj}")
	public ResponseEntity<Response<EmpresaDto>> buscarPorCnpj(@PathVariable("cnpj") String cnpj) {
		log.info("Buscando empresa por CNPJ: {}", cnpj);
		Response<EmpresaDto> response = new Response<EmpresaDto>();
		Optional<EmpresaEntity> empresa = empresaService.buscarPorCnpj(cnpj);
		
		if(!empresa.isPresent()) {
			log.info("Empres não encontrada para o CNPJ: {}", cnpj);
			response.getErrors().add("Empresa não encontrada para o CNPJ " + cnpj);
			return ResponseEntity.badRequest().body(response);
		}
		
		response.setData(this.converterEmpresaDto(empresa.get()));
		return ResponseEntity.ok(response);
		
	}
	
	/**
	 * Popula um DTO com os dados de uma empresa.
	 * 
	 * @param empresa
	 * @return EmpresaDto
	 * */
	private EmpresaDto converterEmpresaDto(EmpresaEntity empresa) {
		EmpresaDto empresaDto = new EmpresaDto();
		empresaDto.setId(empresa.getId());
		empresaDto.setCnpj(empresa.getCnpj());
		empresaDto.setRazaoSocial(empresa.getRazaoSocial());
		
		return empresaDto;
	}
}
