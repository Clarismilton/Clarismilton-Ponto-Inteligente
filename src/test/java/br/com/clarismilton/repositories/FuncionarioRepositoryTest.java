package br.com.clarismilton.repositories;

import java.security.NoSuchAlgorithmException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.clarismilton.entities.EmpresaEntity;
import br.com.clarismilton.entities.FuncionarioEntity;
import br.com.clarismilton.enums.PerfilEnum;
import br.com.clarismilton.utils.SenhaUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class FuncionarioRepositoryTest {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@Autowired
	private EmpresaRepository empresaRepository;

	private static final String EMAIL = "email@email.com";
	private static final String CPF = "24291173474";

	@Before
	public void setUp() throws Exception {
		EmpresaEntity empresa = this.empresaRepository.save(obterDadosEmpresa());
		this.funcionarioRepository.save(obterDadosFuncionario(empresa));
	}

	@After
	public final void tearDown() {
		this.empresaRepository.deleteAll();
	}

	@Test
	public void testBuscarFuncionarioPorEmail() {
	
		FuncionarioEntity funcionario = this.funcionarioRepository.findByEmail(EMAIL);

		assertEquals(EMAIL, funcionario.getEmail());
	}


	@Test
	public void testBuscarFuncionarioPorCpf() {
	
		FuncionarioEntity funcionario = this.funcionarioRepository.findByCpf(CPF);

		assertEquals(CPF, funcionario.getCpf());

	}

	@Test
	public void testBuscarFuncionarioPorEmailECpf() {
		FuncionarioEntity funcionario = this.funcionarioRepository.findByCpfOrEmail(CPF, EMAIL);

		assertNotNull(funcionario);
	}
	
	@Test
	public void testBuscarFuncionarioPorEmailOuCpfParaEmailInvalido() {
		
		FuncionarioEntity funcionario = this.funcionarioRepository.findByCpfOrEmail(CPF, "email@invalido.com");
		

		assertNotNull(funcionario);
	}

	@Test
	public void testBuscarFuncionarioPorEmailECpfParaCpfInvalido() {
	
		FuncionarioEntity funcionario = this.funcionarioRepository.findByCpfOrEmail("12345678901", EMAIL);
		
		assertNotNull(funcionario);
	}

	private FuncionarioEntity obterDadosFuncionario(EmpresaEntity empresa) throws NoSuchAlgorithmException {
		
		FuncionarioEntity funcionario = new FuncionarioEntity();
		
		funcionario.setNome("Fulano de Tal");
		funcionario.setPerfil(PerfilEnum.ROLE_USUARIO);
		funcionario.setSenha(SenhaUtils.gerarBCrypt("123456"));
		funcionario.setCpf(CPF);
		funcionario.setEmail(EMAIL);
		funcionario.setEmpresa(empresa);
		return funcionario;
	}

	private EmpresaEntity obterDadosEmpresa() {
		
		EmpresaEntity empresa = new EmpresaEntity();
		
		empresa.setRazaoSocial("Empresa de exemplo");
		empresa.setCnpj("51463645000100");
		return empresa;
	}

}
