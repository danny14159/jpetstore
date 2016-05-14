package com.fly.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.fly.bean.Sequence;
import com.fly.dao.ISequenceDAO;

/**
 * A data access object (DAO) providing persistence and search support for
 * Sequence entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.fly.Sequence
 * @author MyEclipse Persistence Tools
 */

@Repository
public class SequenceDAO implements ISequenceDAO {
	@PersistenceContext
	private EntityManager entityManager;

	// property constants
	public static final String NEXTID = "nextid";

	public void save(Sequence entity) {
		entityManager.persist(entity);
	}

	public void delete(Sequence entity) {
		entity = entityManager.getReference(Sequence.class, entity.getName());
		entityManager.remove(entity);
	}

	public Sequence update(Sequence entity) {
		Sequence result = entityManager.merge(entity);
		return result;
	}

	public Sequence findById(String id) {
		Sequence instance = entityManager.find(Sequence.class, id);
		return instance;
	}

	/**
	 * Find all Sequence entities.
	 * 
	 * @return List<Sequence> all Sequence entities
	 */
	@SuppressWarnings("unchecked")
	public List<Sequence> findAll() {
		/*
		 * logger.info("finding all Sequence instances"); try { final String
		 * queryString = "select model from Sequence model"; return
		 * getJpaTemplate().executeFind(new JpaCallback() { public Object
		 * doInJpa(EntityManager em) throws PersistenceException { Query query =
		 * em.createQuery(queryString); return query.getResultList(); } }); }
		 * catch (RuntimeException re) { logger.error("find all failed", re);
		 * throw re; }
		 */
		return null;
	}
}