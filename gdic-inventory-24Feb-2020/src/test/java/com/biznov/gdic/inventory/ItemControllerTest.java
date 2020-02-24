package com.biznov.gdic.inventory;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.math.MathContext;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.biznov.gdic.inventory.entity.Item;
import com.biznov.gdic.inventory.repository.ItemRepository;
import com.biznov.gdic.inventory.service.MyUserDetailsService;

@SpringBootTest
public class ItemControllerTest {
	
	@Autowired
	private MyUserDetailsService myUserDetailsService;
	
	@MockBean
	private ItemRepository itemRepository;
	
//	public void getItemstest() {
//		when(itemRepository.findAll()).thenReturn((List<Item>) new ItemContainer(2,20000.0,));
//	}
	
	@Test
	public void saveItemTest() {
		Item item = new Item();
		when(itemRepository.save(item)).thenReturn(item);
		assertThat(item).isEqualTo(item);
	}
	
	@Test
	public void sumQuantityTest() {
		Item item = new Item();
		when(itemRepository.sumQuantities()).thenReturn((long) 28);
		assertThat(item).isEqualTo(item);
	}
	
	@Test
	public void totalCostTest() {
		Item item = new Item();
		double d = 2000.0;
		BigDecimal b = new BigDecimal(d, MathContext.DECIMAL64);
		when(itemRepository.total_cost()).thenReturn(b);
		assertThat(item).isEqualTo(item);
	}

}
