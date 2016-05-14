package com.fly.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import com.fly.bean.Account;
import com.fly.dao.IAccountDAO;
@Repository
public class AccountDAO  implements IAccountDAO{
	@PersistenceContext
	private EntityManager entityManager;
    public void save(Account entity) {

    	entityManager.persist(entity);

    }
  

    public void delete(Account entity) {
    	entityManager.remove(entity);
       
        
    }
  

    public Account update(Account entity) {
    			
            Account result = entityManager.merge(entity);
            			
	            return result;
        
        
    }
    
    public Account findById( String id) {
            Account instance = entityManager.find(Account.class, id);
            return instance;

        }
 
	@SuppressWarnings("unchecked")
	public List<Account> findAll(
		) {
				final String queryString = "select model from Account model";
								Query query = entityManager.createQuery(queryString);
					return query.getResultList();
		
	}




	
}