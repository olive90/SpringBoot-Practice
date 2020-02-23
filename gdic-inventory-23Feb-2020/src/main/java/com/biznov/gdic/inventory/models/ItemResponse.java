package com.biznov.gdic.inventory.models;

public class ItemResponse {

	private Long id;
	private String name;
	private String sku;
	private String manufacturer;
	private String provider;
	private Long minimumStockCount;
	private String transactionDate;
	private String transactionType;
	private int quantiry;
	private double unitCost;
	private String serialNumber;
	private String comments;
	private int status;

	public ItemResponse() {
		super();
	}

	public ItemResponse(Long id, String name, String sku, String manufacturer, String provider, Long minimumStockCount,
			String transactionDate, String transactionType, int quantiry, double unitCost, String serialNumber,
			String comments, int status) {
		super();
		this.id = id;
		this.name = name;
		this.sku = sku;
		this.manufacturer = manufacturer;
		this.provider = provider;
		this.minimumStockCount = minimumStockCount;
		this.transactionDate = transactionDate;
		this.transactionType = transactionType;
		this.quantiry = quantiry;
		this.unitCost = unitCost;
		this.serialNumber = serialNumber;
		this.comments = comments;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public Long getMinimumStockCount() {
		return minimumStockCount;
	}

	public void setMinimumStockCount(Long minimumStockCount) {
		this.minimumStockCount = minimumStockCount;
	}

	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public int getQuantiry() {
		return quantiry;
	}

	public void setQuantiry(int quantiry) {
		this.quantiry = quantiry;
	}

	public double getUnitCost() {
		return unitCost;
	}

	public void setUnitCost(double unitCost) {
		this.unitCost = unitCost;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ItemResponse [id=" + id + ", name=" + name + ", sku=" + sku + ", manufacturer=" + manufacturer
				+ ", provider=" + provider + ", minimumStockCount=" + minimumStockCount + ", transactionDate="
				+ transactionDate + ", transactionType=" + transactionType + ", quantiry=" + quantiry + ", unitCost="
				+ unitCost + ", serialNumber=" + serialNumber + ", comments=" + comments + ", status=" + status + "]";
	}

}
