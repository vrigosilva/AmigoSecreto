package br.com.fiap.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	private Long id;
	
	@Column(name="NOME", nullable=false, unique=true, length=100)
	private String nome;
	
	@Column(name="DESCRICAO", length=1000)
	private String descricao;
	
	@Column(name="ENDERECO", length=100)
	private String endereco;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd/MM/YYYY") 
	@Column(name="DATA", nullable=false)
	private Date data;
	
	@OneToMany(mappedBy="evento", cascade=CascadeType.ALL)
	private List<ParticipacaoEvento> participacoes = new ArrayList<>(); 
	
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



//	
//	// propriedades de conveniencia
//	public void setDataString(String data) {
//		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
//		try {
//			this.setData(df.parse(data));
//		} catch (Exception e) {
//			this.setData(new Date());
//		}
//	}
	
	public List<ParticipacaoEvento> getParticipacoes() {
		return participacoes;
	}
	public void setParticipacoes(List<ParticipacaoEvento> participacoes) {
		this.participacoes = participacoes;
	}
	@Override
	public String toString() {
		return "Evento [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", endereco=" + endereco + ", data="
				+ data + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	
	
	
}