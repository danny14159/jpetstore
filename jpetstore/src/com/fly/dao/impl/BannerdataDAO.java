package com.fly.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.fly.bean.Bannerdata;
import com.fly.bean.Category;
import com.fly.bean.Item;
import com.fly.dao.IBannerdataDAO;


@Repository
public class BannerdataDAO implements IBannerdataDAO {
	@PersistenceContext
	private EntityManager entityManager;
	//提供getXX 和setXX的方法
	public EntityManager getEntityManager() {
		return entityManager;
	}

	//完成对EntityManager对像的注入
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public void delete(Bannerdata entity) {
		Bannerdata b = entityManager.getReference(Bannerdata.class, entity.getFavcategory());

		entityManager.remove(b);

	}

	@SuppressWarnings("unchecked")
	public List<Bannerdata> findAll() {
		final String queryString = "select model from Bannerdata model";
		Query query = entityManager.createQuery(queryString);
		return (List<Bannerdata>)query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Bannerdata> findByBannername(String bannername) {
		String queryString = "from Bannerdata where Bannerdata.bannername=?";
		Query query = entityManager.createQuery(queryString);
		query.setParameter(1, bannername);
		
		return (List<Bannerdata>)query.getResultList();
	}

	public Bannerdata findById(String id) {
		return entityManager.find(Bannerdata.class, id);
		
	}

	

	public void save(Bannerdata entity) {
		   this.entityManager.persist(entity);
	}

	public Bannerdata update(Bannerdata entity) {
		return  this.entityManager.merge(entity);

	}

}
