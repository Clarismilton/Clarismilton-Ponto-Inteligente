package br.com.clarismilton.security.services.impl;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.clarismilton.entities.FuncionarioEntity;
import br.com.clarismilton.security.JwtUserFactory;
import br.com.clarismilton.services.FuncionarioService;

@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private FuncionarioService funcionarioService;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<FuncionarioEntity> funcionario = funcionarioService.buscarPorEmail(email);

		if (funcionario.isPresent()) {
			return JwtUserFactory.create(funcionario.get());
		}

		throw new UsernameNotFoundException("Email não encontrado.");
	}

}