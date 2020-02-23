package com.biznov.gdic.inventory.entity;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//item table

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Item {

	@Id
	@GeneratedValue
	private long id;

	private String name;

	private String sku;

	private String manufacturer;

	private String provider;

	private long minimum_stock_count;

	private String transaction_date;

	private String transaction_type;

	private int quantity;

	private double unit_cost;

	private String serial_number;

	private String comments;

	@Lob
	@Column(columnDefinition = "LONGBLOB")
	private byte[] item_image;

	private int entry_by;

	@CreationTimestamp
	private Date entry_date;

	private int status;

	protected Item() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public long getMinimum_stock_count() {
		return minimum_stock_count;
	}

	public void setMinimum_stock_count(long minimum_stock_count) {
		this.minimum_stock_count = minimum_stock_count;
	}

	public String getTransaction_date() {
		return transaction_date;
	}

	public void setTransaction_date(String transaction_date) {
		this.transaction_date = transaction_date;
	}

	public String getTransaction_type() {
		return transaction_type;
	}

	public void setTransaction_type(String transaction_type) {
		this.transaction_type = transaction_type;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getUnit_cost() {
		return unit_cost;
	}

	public void setUnit_cost(double unit_cost) {
		this.unit_cost = unit_cost;
	}

	public String getSerial_number() {
		return serial_number;
	}

	public void setSerial_number(String serial_number) {
		this.serial_number = serial_number;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public byte[] getItem_image() {
		return item_image;
	}

	public void setItem_image(byte[] item_image) {
		this.item_image = item_image;
	}

	public int getEntry_by() {
		return entry_by;
	}

	public void setEntry_by(int entry_by) {
		this.entry_by = entry_by;
	}

	public Date getEntry_date() {
		return entry_date;
	}

	public void setEntry_date(Date entry_date) {
		this.entry_date = entry_date;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", sku=" + sku + ", manufacturer=" + manufacturer + ", provider="
				+ provider + ", minimum_stock_count=" + minimum_stock_count + ", transaction_date=" + transaction_date
				+ ", transaction_type=" + transaction_type + ", quantity=" + quantity + ", unit_cost=" + unit_cost
				+ ", serial_number=" + serial_number + ", comments=" + comments + ", item_image="
				+ Arrays.toString(item_image) + ", entry_by=" + entry_by + ", entry_date=" + entry_date + ", status="
				+ status + "]";
	}

}
