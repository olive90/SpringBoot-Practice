package com.biznov.gdic.inventory.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.biznov.gdic.inventory.entity.Item;

@Repository
@Transactional
public class ItemDAOService {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public long insert(Item item) {
		entityManager.persist(item);
		return item.getId();
	}

}
