package com.fly.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.fly.bean.Lineitem;
import com.fly.bean.LineitemId;
import com.fly.dao.ILineitemDAO;

@Repository
public class LineitemDAO implements ILineitemDAO {
	//添加一个实体管理器
	private EntityManager entityManager;
	//提供getXX 和setXX的方法
	public EntityManager getEntityManager() {
		return entityManager;
	}
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void delete(Lineitem entity) {
		Lineitem e = entityManager.getReference(Lineitem.class,entity);
		entityManager.remove(e);

	}

	@SuppressWarnings("unchecked")
	public List<Lineitem> findAll() {
		String queryString = "select model from Orders model" ;
		Query query = entityManager.createQuery(queryString);		
		return query.getResultList();
	}

	public Lineitem findById(LineitemId id) {
		return entityManager.find(Lineitem.class, id);
	}

	public List<Lineitem> findByItemid(Object itemid) {
		return findByProperty("itemid", itemid);
	}

	public List<Lineitem> findByProperty(String propertyName, Object value) {
		List<Lineitem> list=null;
		Query query=this.entityManager.createQuery("from Lineitem acc where acc."+propertyName+"=?");
		query.setParameter(1,  value);
		list=query.getResultList();
		return list;

	}

	public List<Lineitem> findByQuantity(Object quantity) {
		return findByProperty("quantity", quantity);
	}

	public List<Lineitem> findByUnitprice(Object unitprice) {
		return findByProperty("unitprice", unitprice);
	}
	
	

	public void save(Lineitem entity) {
		this.entityManager.persist(entity);

	}

	public Lineitem update(Lineitem entity) {
		return this.entityManager.merge(entity);
	}

}
