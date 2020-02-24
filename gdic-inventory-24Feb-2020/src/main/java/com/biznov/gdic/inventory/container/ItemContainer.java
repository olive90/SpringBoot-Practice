package com.biznov.gdic.inventory.container;

import java.math.BigDecimal;
import java.util.List;

public class ItemContainer {

	private Long total_item;
	private BigDecimal total_cost;
	private List<?> all_items;
	
	public ItemContainer() {
		
	}

	public ItemContainer(Long total_item, BigDecimal total_cost, List<?> all_items) {
		super();
		this.total_item = total_item;
		this.total_cost = total_cost;
		this.all_items = all_items;
	}

	public Long getTotal_item() {
		return total_item;
	}

	public void setTotal_item(Long total_item) {
		this.total_item = total_item;
	}

	public BigDecimal getTotal_cost() {
		return total_cost;
	}

	public void setTotal_cost(BigDecimal total_cost) {
		this.total_cost = total_cost;
	}

	public List<?> getAll_items() {
		return all_items;
	}

	public void setAll_items(List<?> all_items) {
		this.all_items = all_items;
	}

}
