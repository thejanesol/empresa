package br.com.dh.empresa.empresa.security;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import br.com.dh.empresa.empresa.model.entities.Funcionario;
import br.com.dh.empresa.empresa.model.repositories.FuncionarioRepository;

@Repository
@Transactional
public class ImplementsUserDetailsService implements UserDetailsService{
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Funcionario funcionario = funcionarioRepository.findOneByEmail(email);
		
		if (funcionario == null) {
			throw new UsernameNotFoundException("Funcionário não cadastrado.");
		}
		
		return new User(funcionario.getUsername(), funcionario.getPassword(), 
				true, true, true, true, funcionario.getAuthorities());
	}

}
