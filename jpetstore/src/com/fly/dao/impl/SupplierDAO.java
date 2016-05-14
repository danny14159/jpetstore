package com.fly.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.fly.bean.Sequence;
import com.fly.bean.Supplier;
import com.fly.dao.ISupplierDAO;

@Repository
public class SupplierDAO implements ISupplierDAO {
	@PersistenceContext
	private EntityManager entityManager;
	
	public void delete(Supplier entity) {
		entity = entityManager.find(Supplier.class, entity.getSuppid());
		entityManager.remove(entity);
	}

	@SuppressWarnings("unchecked")
	public List<Supplier> findAll() {
		String jpql = "from Supplier";
		
		return entityManager.createQuery(jpql).getResultList();
	}

	public Supplier findById(String id) {
		return entityManager.find(Supplier.class, id);
	}

	public void save(Supplier entity) {
		entityManager.persist(entity);
	}

	public Supplier update(Supplier entity) {
		return entityManager.merge(entity);
	}

}
