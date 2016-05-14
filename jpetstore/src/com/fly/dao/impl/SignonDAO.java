package com.fly.dao.impl;

import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.fly.bean.Signon;
import com.fly.dao.ISignonDAO;

/**
 	* A data access object (DAO) providing persistence and search support for Signon entities.
 	 		* Transaction control of the save(), update() and delete() operations must be handled externally by senders of these methods 
 		  or must be manually added to each of these methods for data to be persisted to the JPA datastore.	
 	 * @see adsdaddaddddtouch.pojo.Signon
  * @author MyEclipse Persistence Tools 
 */
@Repository
public class SignonDAO  implements ISignonDAO{
	@PersistenceContext
	private EntityManager entityManager;

    public void save(Signon entity) {
    			
    	entityManager.persist(entity);

        }
   

    public void delete(Signon entity) {
    				
        	entity = entityManager.getReference(Signon.class, entity.getUsername());
        	entityManager.remove(entity);
            		   }

    
  
    public Signon update(Signon entity) {
    				
            Signon result = entityManager.merge(entity);
                       return result;
 
      
    }
    
    public Signon findById( String id) {
    				
            Signon instance = entityManager.find(Signon.class, id);
            return instance;
          }
   
    


    @SuppressWarnings("unchecked")
    public List<Signon> findByProperty(String propertyName, final Object value
        ) {
    				
			final String queryString = "select model from Signon model where model." 
			 						+ propertyName + "= :propertyValue";
								Query query = entityManager.createQuery(queryString);
					query.setParameter("propertyValue", value);
					return query.getResultList();

	
	}			
	
	
	@SuppressWarnings("unchecked")
	public List<Signon> findAll(
		) {
					
			final String queryString = "select model from Signon model";
								Query query = entityManager.createQuery(queryString);
					return query.getResultList();

	
	}
	
}