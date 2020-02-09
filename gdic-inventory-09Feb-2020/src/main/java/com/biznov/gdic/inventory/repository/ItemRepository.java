package com.biznov.gdic.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.biznov.gdic.inventory.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{

}
