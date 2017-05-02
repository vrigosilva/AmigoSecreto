package br.com.fiap.dao;

import java.util.List;

public interface Dao<T> {
	
	void insert(T entidade);
	
	void update(T entidade);
	
	void delete(Long id);
	
	List<T> findAll();

	T find(Long id); 
}
