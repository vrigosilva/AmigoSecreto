package br.com.fiap.entidades;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="EVENTO")
public class Evento implements Serializable{
	
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="NOME", nullable=false, unique=true, length=100)
	private String nome;
	
	@Column(name="DESCRICAO", length=1000)
	private String descricao;
	
	@Column(name="ENDERECO", length=100)
	private String endereco;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd") 
	@Column(name="DATA", nullable=false)
	private Date data;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="EVENTO_USUARIO", 
	joinColumns={@JoinColumn(name="EVENTO_ID", referencedColumnName="ID", nullable=false, updatable=false)},
	inverseJoinColumns={@JoinColumn(name="USUARIO_ID", referencedColumnName="ID", nullable=true, updatable=false)})
	private Set<Usuario> participantes = new HashSet<>();
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Set<Usuario> getParticipantes() {
		return participantes;
	}
	public void setParticipantes(Set<Usuario> participantes) {
		this.participantes = participantes;
	}
	
	
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Evento other = (Evento) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	// propriedades de conveniencia
	public void setDataString(String data) {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		try {
			this.setData(df.parse(data));
		} catch (Exception e) {
			this.setData(new Date());
		}
	}
	
	
	
	
}