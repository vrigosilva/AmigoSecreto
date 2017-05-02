package br.com.fiap.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.fiap.entidades.Usuario;

@Repository
@Transactional
public class UsuarioDao {
	

	@PersistenceContext
	private EntityManager em;
	

	public void persist(Usuario entidade) {
		em.persist(entidade);
	}

	public void update(Usuario entidade) {
		em.merge(entidade);
	}

	public void remove(Usuario entity ){
	     em.remove( entity );
	}
	public void removeById( long entityId ){
		Usuario entity = find( entityId );
		remove( entity );
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> findAll() {
		List<Usuario> lista = em.createQuery("From Usuario").getResultList();
		return lista;
	}

	public Usuario find(Long id) {
		Usuario entidade = em.find(Usuario.class, id);
		return entidade;
	}

	public Usuario findByEmail(String email){
		List<Usuario> lista = em.createQuery("Select u From Usuario u where u.email= :email ", Usuario.class)
								.setParameter("email", email).getResultList();
		if(lista.isEmpty()){
			return null;
		}
				
		return lista.get(0);
	}
}
