package br.com.clarismilton.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.clarismilton.entities.EmpresaEntity;
import br.com.clarismilton.repositories.EmpresaRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class EmpresaServiceTest {

	@MockBean
	private EmpresaRepository empresaRepository;
	
	@Autowired
	private EmpresaService empresaService;
	
	private static final String CNPJ = "51463645000100";
	
	@Before
	public void setUp() throws Exception {
		BDDMockito.given(this.empresaRepository.findByCnpj(Mockito.anyString())).willReturn(new EmpresaEntity());
		BDDMockito.given(this.empresaRepository.save(Mockito.any(EmpresaEntity.class))).willReturn(new EmpresaEntity());
	}
	
	@Test
	public void testBuscarEmpresaPorCnpj() {
		Optional<EmpresaEntity> empresa = this.empresaService.buscarPorCnpj(CNPJ);
		
		assertTrue(empresa.isPresent());
		
	}
	
	@Test
	public void testPersistirEmpresa() {
		EmpresaEntity empresa = this.empresaService.persistir(new EmpresaEntity());
		
		assertNotNull(empresa);
	}
	
}
