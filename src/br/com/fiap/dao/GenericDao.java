package br.com.fiap.dao;

import java.util.List;

import javax.persistence.EntityManager;


public abstract class GenericDao<T> implements Dao<T> {
	

	private final Class<T> classe;

		
	public GenericDao(Class<T> classe) {
		this.classe = classe;
	}
	abstract EntityManager getEntityManager();
	
	@Override
	public void insert(T entidade) {
			getEntityManager().persist(entidade);
	}

	@Override
	public void update(T entidade) {
		getEntityManager().merge(entidade);
	}
	
	public void delete(Long id) {
		getEntityManager().remove(getEntityManager().find(classe, id));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		List<T> lista = getEntityManager().createQuery("From " + classe.getSimpleName()).getResultList();
		return lista;
	}

	@Override
	public T find(Long id) {
		T entidade = getEntityManager().find(classe, id);
		return entidade;
	}
	
}
