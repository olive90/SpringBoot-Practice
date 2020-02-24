package com.biznov.gdic.inventory.models;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ItemRequest {

	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	private Date searchStartDate;
	@JsonFormat(pattern = "dd-MM-yyy HH:mm:ss")
	private Date searchEndDate;
	private int status;

	public ItemRequest() {
		super();
	}

	public ItemRequest(Date searchStartDate, Date searchEndDate, int status) {
		super();
		this.searchStartDate = searchStartDate;
		this.searchEndDate = searchEndDate;
		this.status = status;
	}

	public Date getSearchStartDate() {
		return searchStartDate;
	}

	public void setSearchStartDate(Date searchStartDate) {
		this.searchStartDate = searchStartDate;
	}

	public Date getSearchEndDate() {
		return searchEndDate;
	}

	public void setSearchEndDate(Date searchEndDate) {
		this.searchEndDate = searchEndDate;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ItemRequest [searchStartDate=" + searchStartDate + ", searchEndDate=" + searchEndDate + ", status="
				+ status + "]";
	}

}
