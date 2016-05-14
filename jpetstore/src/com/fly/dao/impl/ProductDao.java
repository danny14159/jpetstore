package com.fly.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.fly.bean.Pager;
import com.fly.bean.Product;
import com.fly.dao.IProductDao;

@Repository
public class ProductDao implements IProductDao {

	@PersistenceContext
	private EntityManager entityManager;
	//property contains
	public static final String NAME = "name";
	public static final String DESCN = "descn";
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void delete(Product entity) {
		entityManager.remove(entity);
	}

	@SuppressWarnings("unchecked")
	public List<Product> findAll() {
		String queryString = "from Product";
		Query query = entityManager.createQuery(queryString);
		return (List<Product>)query.getResultList();
		
	}

	public Product findById(String id) {
		Product product=entityManager.find(Product.class, id);
		return product;
	}

	public void save(Product entity) {
		entityManager.persist(entity);
	}

	public Product update(Product entity) {
		Product product=entityManager.merge(entity);
		return product;
	}

	@SuppressWarnings("unchecked")
	public List<Product> findByCategoryId(String categoryId) {
		Query query = entityManager.createQuery("from Product model where model.category.catid=?");
		query.setParameter(1, categoryId);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Product> search(String key) {
		key = key.toLowerCase();
		Query query = entityManager.createQuery(
				"from Product model where " +
				"lower(model.name) like :key or " +
				"lower(model.productid) like :key or " +
				"lower(model.descn) like :key");
		query.setParameter("key", "%"+key+"%");
		return query.getResultList();
	}
	
	public Pager searchByPage(String key,int pageSize,int pageNum) {
		key = key.toLowerCase();
		Query query = entityManager.createQuery(
				"from Product model where " +
				"lower(model.name) like :key or " +
				"lower(model.productid) like :key or " +
		"lower(model.descn) like :key");
		
		Query queryCount = entityManager.createQuery(
				"select count(*) "+
				"from Product model where " +
				"lower(model.name) like :key or " +
				"lower(model.productid) like :key or " +
		"lower(model.descn) like :key");
		query.setParameter("key", "%"+key+"%");
		query.setFirstResult((pageNum-1)*pageSize);
		query.setMaxResults(pageSize);
		
		queryCount.setParameter("key", "%"+key+"%");
		
		Pager pager = new Pager(pageNum, pageSize, (Long)queryCount.getSingleResult(), query.getResultList());
		return pager;
	}

}
