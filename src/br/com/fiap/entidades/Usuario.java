package br.com.fiap.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class Usuario implements Serializable,UserDetails{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="NOME", nullable=false, length=100)
	private String nome;
	
	@Column(name="EMAIL", nullable=false, unique=true, length=100)
	private String email;
	
	@Column(name="SENHA", nullable=false, length=50)
	private String senha;
	
	@Column(name="CPF", nullable=false, unique=true, length=14)
	private String cpf;
	
	@Temporal(TemporalType.DATE)
	private Date nascimento;
	
	@Column(name="TELEFONE", length=12)
	private String telefone;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="USUARIO_EVENTO", 
		joinColumns={@JoinColumn(name="USUARIO_ID",nullable=false,unique=true, updatable=false)},
		inverseJoinColumns={@JoinColumn(name="EVENTO_ID",nullable=true, unique=true, updatable=false)})
	private List<Evento> eventos = new ArrayList<>(); 
	
	@OneToMany(fetch=FetchType.EAGER)
	private List<Permissao> permissoes = new ArrayList<>();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getNascimento() {
		return nascimento;
	}
	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public List<Permissao> getPermissoes() {
		return permissoes;
	}
	public void setPermissoes(List<Permissao> permissoes) {
		this.permissoes = permissoes;
	}
	
	
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", nascimento=" + nascimento + ", cpf=" + cpf + ", telefone="
				+ telefone + ", email=" + email + ", senha=" + senha + "]";
	}

	// UserDetails - SpringSecurit
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.permissoes;
	}
	@Override
	public String getPassword() {
		return this.senha;
	}
	@Override
	public String getUsername() {
		return this.email;
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return true;
	}

	
}
