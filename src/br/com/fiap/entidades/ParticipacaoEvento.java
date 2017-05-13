package br.com.fiap.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PARTICIPACAO_EVENTO")
public class ParticipacaoEvento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="usuario_id", nullable=false)
	private Usuario participante;
	
	@Column(name="usuario_sorteado_id", nullable=false)
	private Usuario usuarioSorteado;
	
	private Evento evento;
	
	private Boolean isAdmin;
}
