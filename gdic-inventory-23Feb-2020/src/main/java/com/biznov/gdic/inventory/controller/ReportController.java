package com.biznov.gdic.inventory.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.biznov.gdic.inventory.entity.Item;
import com.biznov.gdic.inventory.models.ItemDetails;
import com.biznov.gdic.inventory.repository.ItemRepository;

@RestController
public class ReportController {
	
	@Autowired
	ItemRepository itemRepository;
	
	@GetMapping("/itemDetails")
	public List<ItemDetails> getItemDetails(@RequestParam(required = false) String startDate, @RequestParam(required = false) String endDate){
		
		List<ItemDetails> itemdetailsList = new ArrayList<>();
		List<Item> itemList;
		
		itemList = itemRepository.findAllBetweenDates(startDate, endDate);
		
		for(Item item : itemList) {
			ItemDetails itemDetails = new ItemDetails();
			itemDetails.setId(item.getId());
			itemDetails.setManufacturer(item.getManufacturer());
			itemDetails.setName(item.getName());
			itemDetails.setQuantity(item.getQuantity());
			itemDetails.setSku(item.getSku());
			itemDetails.setStatus(item.getStatus());
			itemDetails.setTransactionDate(item.getTransaction_date());
			itemDetails.setUnitCost(item.getUnit_cost());
			
			itemdetailsList.add(itemDetails);
		}
		return itemdetailsList;
		
	}
	
	

}
