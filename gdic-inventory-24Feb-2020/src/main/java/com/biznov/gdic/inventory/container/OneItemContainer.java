package com.biznov.gdic.inventory.container;

import java.math.BigDecimal;
import com.biznov.gdic.inventory.entity.Item;

public class OneItemContainer {

	private BigDecimal perItem_totalCost;
	private Item item;

	public OneItemContainer(BigDecimal perItem_totalCost, Item item) {
		super();
		this.perItem_totalCost = perItem_totalCost;
		this.item = item;
	}

	public BigDecimal getPerItem_totalCost() {
		return perItem_totalCost;
	}

	public void setPerItem_totalCost(BigDecimal perItem_totalCost) {
		this.perItem_totalCost = perItem_totalCost;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

}
