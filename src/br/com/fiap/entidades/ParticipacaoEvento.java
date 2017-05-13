package br.com.fiap.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="PARTICIPACAO_EVENTO")
public class ParticipacaoEvento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="USUARIO_ID", nullable= false)
	private Usuario participante;
	
	@ManyToOne
	@JoinColumn(name="USUARIO_SORTEADO_ID", nullable= true)
	private Usuario participanteSorteado;
	
	@ManyToOne
	@JoinColumn(name="EVENTO_ID", nullable= false)
	private Evento evento;
	
	@Column(name="ADMIN")
	private Boolean isAdmin;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getParticipante() {
		return participante;
	}

	public void setParticipante(Usuario participante) {
		this.participante = participante;
	}

	public Usuario getParticipanteSorteado() {
		return participanteSorteado;
	}

	public void setParticipanteSorteado(Usuario participanteSorteado) {
		this.participanteSorteado = participanteSorteado;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	@Override
	public String toString() {
		return "ParticipacaoEvento [id=" + id + ", participante=" + participante + ", participanteSorteado="
				+ participanteSorteado + ", evento=" + evento + ", isAdmin=" + isAdmin + "]";
	}
	
	
	
	
}
