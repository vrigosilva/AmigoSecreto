package br.com.fiap.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.fiap.entidades.Evento;
import br.com.fiap.entidades.Usuario;

@Repository
@Transactional
public class EventoDao {
	

	@PersistenceContext
	private EntityManager em;
	

	public void persist(Evento e) {
		Set<Usuario> set = new HashSet<>(); 
		e.getParticipantes().forEach(u-> set.add(em.find(Usuario.class,u.getId())));
		e.setParticipantes(set);
		em.persist(e);
	}

	public void update(Evento entidade) {
		em.merge(entidade);
	}

	public void remove(Evento entity ){
	     em.remove( entity );
	}
	
	public void removeById(Long entityId ){
		Evento entity = find(entityId);
		remove( entity );
	}

	@SuppressWarnings("unchecked")
	public List<Evento> findAll() {
		List<Evento> lista = em.createQuery("From Evento").getResultList();
		return lista;
	}

	public Evento find(Long id) {
		Evento entidade = em.find(Evento.class, id);
		return entidade;
	}

	public List<Evento> findByParticipante(Usuario participante){
		List<Evento> lista = em.createQuery("Select e From Evento e where e.participantes= :participante ", Evento.class)
								.setParameter("participante", participante).getResultList();
		if(lista.isEmpty()){
			return null;
		}
				
		return lista;
	}
}
