package org.jbiz.demo.db.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.jbiz.demo.db.bean.UserEntity;


public class UserDao extends BaseZDao {

	public UserDao(EntityManager _em) {
		super(_em);
	}
	
	
	public UserEntity findByAccount(String account) {
		
		String queryString = "from UserEntity where account =:paccount";
		

		Query query = getEntityManager().createQuery(queryString);

		query.setParameter("paccount", account);
		
		try {
			return (UserEntity)query.getSingleResult();
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
	}
	
	@SuppressWarnings("unchecked")
	public List<UserEntity> findUserList() {

		String queryString = "from UserEntity";
		

		Query query = getEntityManager().createQuery(queryString);

		return (List<UserEntity>)query.getResultList();
		
		
	}
}
