package com.fly.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.fly.bean.Inventory;
import com.fly.dao.IInventoryDAO;
@Repository
public class InventoryDAO implements IInventoryDAO {
	@PersistenceContext
	private EntityManager entityManager;
	public static final String ITEMID = "itemid";
	@SuppressWarnings("unused")
	private double qty;
	public void delete(Inventory entity) {
		entity = entityManager.getReference(Inventory.class,
				entity.getItemid());
	entityManager.remove(entity);

	}

	@SuppressWarnings("unchecked")
	public List<Inventory> findAll() {
		final String queryString = "select model from Inventory model";
		Query query = entityManager.createQuery(queryString);
		return (List<Inventory>)query.getResultList();
	}

	public Inventory findById(String id) {
		Inventory instance = entityManager.find(Inventory.class, id);
		return instance;
	}

	public void save(Inventory entity) {
		entityManager.persist(entity);

	}

	public Inventory update(Inventory entity) {
		Inventory result = entityManager.merge(entity);
		return result;
	}

} 