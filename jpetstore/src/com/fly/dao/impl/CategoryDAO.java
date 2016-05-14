package com.fly.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.fly.bean.Category;
import com.fly.dao.ICategoryDAO;

@Repository
public class CategoryDAO implements ICategoryDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	// property constants
	public static final String NAME = "name";
	public static final String DESCN = "descn";

	public void save(Category entity) {
		entityManager.persist(entity);
	}

	public void delete(Category entity) {
		entity = entityManager.getReference(Category.class, entity.getCatid());
		entityManager.remove(entity);
	}

	public Category update(Category entity) {
		return entityManager.merge(entity);
	}

	public Category findById(String id) {
		return entityManager.find(Category.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Category> findAll() {
		final String queryString = "select model from Category model";
		Query query = entityManager.createQuery(queryString);
		return (List<Category>)query.getResultList();
	}

}