package com.biznov.gdic.inventory.models;

public class ItemDetails {

	private Long id;
	private String transactionDate;
	private String name;
	private String sku;
	private String manufacturer;
	private int quantity;
	private double unitCost;
	private int status;

	public ItemDetails() {
		super();
	}

	public ItemDetails(Long id, String transactionDate, String name, String sku, String manufacturer, int quantity,
			double unitCost, int status) {
		super();
		this.id = id;
		this.transactionDate = transactionDate;
		this.name = name;
		this.sku = sku;
		this.manufacturer = manufacturer;
		this.quantity = quantity;
		this.unitCost = unitCost;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getUnitCost() {
		return unitCost;
	}

	public void setUnitCost(double unitCost) {
		this.unitCost = unitCost;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ItemDetails [id=" + id + ", transactionDate=" + transactionDate + ", name=" + name + ", sku=" + sku
				+ ", manufacturer=" + manufacturer + ", quantity=" + quantity + ", unitCost=" + unitCost + ", status="
				+ status + ", totalUnit=" + "]";
	}

}
