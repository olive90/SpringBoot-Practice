package com.biznov.gdic.inventory.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.biznov.gdic.inventory.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{

	@Query(value = "select sum(quantity) from Item")
	 public Long sumQuantities();
	
	@Query(value = "select sum(quantity*unit_cost) from Item")
	public BigDecimal total_cost();
	
	@Query(value = "select sum(quantity*unit_cost) from Item where id = :id")
	public BigDecimal perItem_totalCost(@Param(value = "id") Long id);
	
	@Query(value = "select * from item where entry_date between :startDate and :endDate", nativeQuery = true)
	public List<Item> findAllBetweenDates(@Param(value = "startDate") String startDate, @Param(value = "endDate") String endDate);
	
	

}
