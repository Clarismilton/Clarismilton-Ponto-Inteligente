package br.com.clarismilton.repositories;

import static org.junit.Assert.assertEquals;

import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.clarismilton.entities.EmpresaEntity;
import br.com.clarismilton.entities.FuncionarioEntity;
import br.com.clarismilton.entities.LancamentoEntity;
import br.com.clarismilton.enums.PerfilEnum;
import br.com.clarismilton.enums.TipoEnum;
import br.com.clarismilton.utils.SenhaUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class LancamentoRepositoryTest {
	
	@Autowired
	private LancamentoRepository lancamentoRepository;
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	private Long funcionarioId;

	@Before
	public void setUp() throws Exception {
		EmpresaEntity empresa = this.empresaRepository.save(obterDadosEmpresa());
		
		FuncionarioEntity funcionario = this.funcionarioRepository.save(obterDadosFuncionario(empresa));
		this.funcionarioId = funcionario.getId();
		
		this.lancamentoRepository.save(obterDadosLancamentos(funcionario));
		this.lancamentoRepository.save(obterDadosLancamentos(funcionario));
	}

	@After
	public void tearDown() throws Exception {
		this.empresaRepository.deleteAll();
	}

	@Test
	public void testBuscarLancamentosPorFuncionarioId() {
		List<LancamentoEntity> lancamentos = this.lancamentoRepository.findByFuncionarioId(funcionarioId);
		
		assertEquals(2, lancamentos.size());
	}
	
	@Test
	public void testBuscarLancamentosPorFuncionarioIdPaginado() {
		PageRequest page = new PageRequest(0, 10);
		Page<LancamentoEntity> lancamentos = this.lancamentoRepository.findByFuncionarioId(funcionarioId, page);
		
		assertEquals(2, lancamentos.getTotalElements());
	}
	
	private LancamentoEntity obterDadosLancamentos(FuncionarioEntity funcionario) {
		LancamentoEntity lancameto = new LancamentoEntity();
		lancameto.setData(new Date());
		lancameto.setTipo(TipoEnum.INICIO_ALMOCO);
		lancameto.setFuncionario(funcionario);
		return lancameto;
	}

	private FuncionarioEntity obterDadosFuncionario(EmpresaEntity empresa) throws NoSuchAlgorithmException {
		FuncionarioEntity funcionario = new FuncionarioEntity();
		funcionario.setNome("Fulano de Tal");
		funcionario.setPerfil(PerfilEnum.ROLE_USUARIO);
		funcionario.setSenha(SenhaUtils.gerarBCrypt("123456"));
		funcionario.setCpf("24291173474");
		funcionario.setEmail("email@email.com");
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
