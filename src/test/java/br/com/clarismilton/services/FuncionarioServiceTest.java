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

import br.com.clarismilton.entities.FuncionarioEntity;
import br.com.clarismilton.repositories.FuncionarioRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class FuncionarioServiceTest {
	
	@MockBean
	private FuncionarioRepository funcionarioRepository;
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	@Before
	public void setUp() throws Exception{
		BDDMockito.given(this.funcionarioRepository.save(Mockito.any(FuncionarioEntity.class))).willReturn(new FuncionarioEntity());
		BDDMockito.given(this.funcionarioRepository.findOne(Mockito.anyLong())).willReturn(new FuncionarioEntity());
		BDDMockito.given(this.funcionarioRepository.findByEmail(Mockito.anyString())).willReturn(new FuncionarioEntity());
		BDDMockito.given(this.funcionarioRepository.findByCpf(Mockito.anyString())).willReturn(new FuncionarioEntity());
	}
	
	@Test
	public void testPersistirFuncionario() {
		FuncionarioEntity funcionario = this.funcionarioService.persistir(new FuncionarioEntity());
		
		assertNotNull(funcionario);
	}
	
	@Test
	public void testBuscarFuncionarioPorId() {
		Optional<FuncionarioEntity> funcionario = this.funcionarioService.buscarPorId(1L);
		
		assertTrue(funcionario.isPresent());
	}
	
	@Test
	public void testBuscarFuncionarioPorEmail() {
		Optional<FuncionarioEntity> funcionario = this.funcionarioService.buscarPorEmail("email@email.com");
		
		assertTrue(funcionario.isPresent());
	}

	@Test
	public void testBuscarFuncionarioPorCpf() {
		Optional<FuncionarioEntity> funcionario = this.funcionarioService.buscarPorCpf("24291173474");
		
		assertTrue(funcionario.isPresent());
	}
	
}
