package com.fly.dao.impl;

import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.fly.bean.Profile;
import com.fly.dao.IProfileDAO;
@Repository
public class ProfileDAO implements IProfileDAO {
	@PersistenceContext
	private EntityManager entityManager;

	public void save(Profile entity) {

		entityManager.persist(entity);

	}

	public void delete(Profile entity) {

		entity = entityManager.getReference(Profile.class, entity.getUserid());
		entityManager.remove(entity);

	}

	public Profile update(Profile entity) {

		Profile result = entityManager.merge(entity);

		return result;

	}

	public Profile findById(String id) {

		Profile instance = entityManager.find(Profile.class, id);
		return instance;

	}

	@SuppressWarnings("unchecked")
	public List<Profile> findByProperty(String propertyName, final Object value) {

		final String queryString = "select model from Profile model where model."
				+ propertyName + "= :propertyValue";
		Query query = entityManager.createQuery(queryString);
		query.setParameter("propertyValue", value);
		return query.getResultList();

	}

	@SuppressWarnings("unchecked")
	public List<Profile> findAll() {
		final String queryString = "select model from Profile model";
		Query query = entityManager.createQuery(queryString);
		return query.getResultList();

	}

}