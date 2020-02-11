package com.biznov.gdic.inventory.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.biznov.gdic.inventory.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{

	@Query(value = "select sum(quantity) from Item")
	 public Long sumQuantities();
	
	@Query(value = "select sum(quantity*unit_cost) from Item")
	public BigDecimal total_cost();

}
