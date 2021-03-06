package com.biznov.gdic.inventory.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.biznov.gdic.inventory.entity.Item;
import com.biznov.gdic.inventory.repository.ItemRepository;
import com.biznov.gdic.inventory.service.ItemDAOService;

import javassist.NotFoundException;

@RestController
public class ItemController {

	@Autowired
	ItemDAOService itemDaoService;

	@Autowired
	ItemRepository itemRepository;

	// Retrieve all items
	@RequestMapping(value = "/items", method = RequestMethod.GET)
	public List<Item> getAllItems() throws NotFoundException {
		
		try {
			itemRepository.findAll();
			Long a = itemRepository.sumQuantities();
			BigDecimal b = itemRepository.total_cost();
			System.out.println(a+" & "+b);
		} catch (Exception e) {
			throw new NotFoundException("Items not found", e);
		}
		
		return itemRepository.findAll();
	}

	// Add a new item
	@RequestMapping(value = "/add_item", method = RequestMethod.POST)
	public ResponseEntity<?> insertItem(@RequestBody Item item) throws Exception {

		try {

			itemRepository.save(item);

		} catch (Exception e) {
			throw new Exception("Not Create", e);
		}

		return ResponseEntity.ok().body(item);

	}

	// Get a single item
	@RequestMapping(value = "/items/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getItemById(@PathVariable(value = "id") long itemId, Optional<Item> item)
			throws NotFoundException {

		try {
			item = itemRepository.findById(itemId);
		} catch (Exception e) {
			throw new NotFoundException("Item not found ", e);
		}

		return ResponseEntity.ok().body(item);

	}

	// Update item
	@RequestMapping(value = "/items/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateItem(@PathVariable(value = "id") long itemid, @RequestBody Item itemDetail)
			throws NotFoundException {

		try {
			Item item = itemRepository.findById(itemid).orElseGet(null);

			item.setName(itemDetail.getName());
			item.setSku(itemDetail.getSku());
			item.setManufacturer(itemDetail.getManufacturer());
			item.setProvider(itemDetail.getProvider());
			item.setMinimum_stock_count(itemDetail.getMinimum_stock_count());
			item.setTransaction_date(itemDetail.getTransaction_date());
			item.setTransaction_type(itemDetail.getTransaction_type());
			item.setQuantity(itemDetail.getQuantity());
			item.setUnit_cost(itemDetail.getUnit_cost());
			item.setSerial_number(itemDetail.getSerial_number());
			item.setComments(itemDetail.getComments());
			item.setItem_image(itemDetail.getItem_image());
			item.setEntry_by(itemDetail.getEntry_by());
			item.setEntry_date(itemDetail.getEntry_date());
			item.setStatus(itemDetail.getStatus());

			Item updateItem = itemRepository.save(item);

			return ResponseEntity.ok().body(updateItem);

		} catch (Exception e) {
			throw new NotFoundException("Item not found ", e);
		}

	}

	// Delete item
	@RequestMapping(value = "/items/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<HttpStatus> deleteItem(@PathVariable(value = "id") long itemId) throws NotFoundException {
		try {
			Item item = itemRepository.findById(itemId).orElseGet(null);
			itemRepository.delete(item);
		} catch (Exception e) {
			throw new NotFoundException("Item Not Found ", e);
		}
		return ResponseEntity.ok().body(HttpStatus.OK);
	}

}
