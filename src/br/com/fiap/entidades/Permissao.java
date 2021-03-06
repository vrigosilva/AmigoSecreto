package br.com.fiap.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Permissao  implements Serializable, GrantedAuthority{

	private static final long serialVersionUID = 1L;

	public Permissao(){}
	public Permissao(String nome) {
		super();
		this.nome = nome;
	}

	@Id
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String getAuthority() {
		return this.nome;
	}
	
	
}
