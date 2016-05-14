package com.fly.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.fly.bean.Item;
import com.fly.dao.IItemDAO;

@Repository
public class ItemDAO implements IItemDAO {
	@PersistenceContext
	private EntityManager entityManager;
	
	// property constants
	public static final String LISTPRICE = "listprice";
	public static final String UNITCOST = "unitcost";
	public static final String STATUS = "status";
	public static final String ATTR1 = "attr1";
	public static final String ATTR2 = "attr2";
	public static final String ATTR3 = "attr3";
	public static final String ATTR4 = "attr4";
	public static final String ATTR5 = "attr5";

	public void save(Item entity) {
		entityManager.persist(entity);
	}

	public void delete(Item entity) {
		entity = entityManager.getReference(Item.class,
					entity.getItemid());
		entityManager.remove(entity);
	}

	
	public Item update(Item entity) {
		Item result = entityManager.merge(entity);
		return result;
	}

	public Item findById(String id) {
		Item instance = entityManager.find(Item.class, id);
		return instance;
	}

	@SuppressWarnings("unchecked")
	public List<Item> findAll() {
		final String queryString = "select model from Item model";
		Query query = entityManager.createQuery(queryString);
		return (List<Item>)query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Item> listByProductId(String productId){
		String queryString = "from Item where product.productid=?";
		Query query = entityManager.createQuery(queryString);
		query.setParameter(1, productId);
		
		return (List<Item>)query.getResultList();
	}
}