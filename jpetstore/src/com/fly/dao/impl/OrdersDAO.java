package com.fly.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.fly.bean.Account;
import com.fly.bean.Bannerdata;
import com.fly.bean.Category;
import com.fly.bean.Orders;
import com.fly.dao.IOrdersDAO;
@Repository
public class OrdersDAO implements IOrdersDAO {
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
	public void delete(Orders entity) {
		Orders o = entityManager.getReference(Orders.class, entity.getOrderid());
		entityManager.remove(o);
	}

	@SuppressWarnings("unchecked")
	public List<Orders> findAll() {
		final String queryString = "select model from Orders model";
		Query query = entityManager.createQuery(queryString);
		return (List<Orders>)query.getResultList();
	}

	public Orders findById(double id) {
		return entityManager.find(Orders.class, id);
		
	}

	@SuppressWarnings("unchecked")
	public List<Orders> findByUserId(String userid) {
		String queryString = "from Orders model  where model.account.userid=?";
		Query query = entityManager.createQuery(queryString);
		query.setParameter(1, userid);	
		return (List<Orders>)query.getResultList();
	}

	public void save(Orders entity) {
		   this.entityManager.persist(entity);

	}

	public Orders update(Orders entity) {
		return  this.entityManager.merge(entity);

	}

	public Orders findMaxOrderBySql() {
		// TODO Auto-generated method stub
	String queryString ="from Orders where orderid=(select max(orderid) from Orders)";
	Query query = entityManager.createQuery(queryString);
	return (Orders) query.getSingleResult();

	}

}
