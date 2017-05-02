package br.com.fiap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.fiap.dao.UsuarioDao;
import br.com.fiap.entidades.Usuario;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioDao dao;
	
	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		Usuario usuario = dao.findByEmail(arg0);
		if(usuario == null)
			throw new UsernameNotFoundException("Usuario não encontrado!");
		return usuario;
	}

}
