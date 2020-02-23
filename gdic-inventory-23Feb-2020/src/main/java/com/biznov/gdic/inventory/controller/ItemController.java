package com.biznov.gdic.inventory.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.biznov.gdic.inventory.container.ItemContainer;
import com.biznov.gdic.inventory.container.OneItemContainer;
import com.biznov.gdic.inventory.entity.Item;
import com.biznov.gdic.inventory.repository.ItemRepository;
import javassist.NotFoundException;

@RestController
public class ItemController {

	@Autowired
	ItemRepository itemRepository;

	// Retrieve all items
	@RequestMapping(value = "/getItems", method = RequestMethod.GET)
	public ItemContainer getAllItems() throws NotFoundException {

		try {

			List<Item> all_items = itemRepository.findAll();
			Long total_item = itemRepository.sumQuantities();
			BigDecimal total_cost = itemRepository.total_cost();

			return new ItemContainer(total_item, total_cost, all_items);

		} catch (Exception e) {
			throw new NotFoundException("We were unable to find the specified resource.", e);
		}

	}

	// Add a new item
	@RequestMapping(value = "/addItem", method = RequestMethod.POST)
	public ResponseEntity<?> insertItem(@RequestBody Item item, HttpServletRequest httpRequest,
			HttpServletResponse httpResponse) throws Exception {

		try {

			itemRepository.save(item);

		} catch (Exception e) {
			throw new Exception("Not Create", e);
		}

		return ResponseEntity.ok().body(item);

	}

	// Get a single item
	@RequestMapping(value = "/getItem", method = RequestMethod.GET)
	@ResponseBody
	public OneItemContainer getItemById(@RequestParam long itemId, BigDecimal perItem_totalCost, Item item,
			HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws NotFoundException {

		try {

			item = itemRepository.getOne(itemId);
			perItem_totalCost = itemRepository.perItem_totalCost(itemId);
			if (item == null) {
				throw new NotFoundException("We were unable to find the specified resource.");
			}

		} catch (Exception e) {
			throw new NotFoundException("We were unable to find the specified resource.", e);
		}
		return new OneItemContainer(perItem_totalCost, item);
	}

	// Update item
	@RequestMapping(value = "/updateItem", method = RequestMethod.PUT)
	public ResponseEntity<?> updateItem(@RequestParam long itemId, @RequestBody Item itemDetail,
			HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws NotFoundException {

		try {
			Item item = itemRepository.findById(itemId).orElseGet(null);

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
			throw new NotFoundException("We were unable to find the specified resource.", e);
		}

	}

	// Delete item
	@RequestMapping(value = "/deleteItem", method = RequestMethod.DELETE)
	public ResponseEntity<HttpStatus> deleteItem(@RequestParam long itemId) throws NotFoundException {
		try {
			Item item = itemRepository.findById(itemId).orElseGet(null);
			itemRepository.delete(item);
		} catch (Exception e) {
			throw new NotFoundException("We were unable to find the specified resource.", e);
		}
		return ResponseEntity.ok().body(HttpStatus.OK);
	}

}
