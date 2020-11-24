package com.example.referencedata.dao.entity;

public class LogisticChannel {

	private int logisticGroupNumber;

	private int storeNumber;

	private String streamNumber;

	private String startDate;

	private String warehouseNumber;

	private String endDate;

	public int getStoreNumber() {
		return storeNumber;
	}

	public String getStreamNumber() {
		return streamNumber;
	}

	public void setStoreNumber(int storeNumber) {
		this.storeNumber = storeNumber;
	}

	public void setStreamNumber(String streamNumber) {
		this.streamNumber = streamNumber;
	}

	public int getLogisticGroupNumber() {
		return logisticGroupNumber;
	}

	public void setLogisticGroupNumber(int logisticGroupNumber) {
		this.logisticGroupNumber = logisticGroupNumber;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getWarehouseNumber() {
		return warehouseNumber;
	}

	public void setWarehouseNumber(String warehouseNumber) {
		this.warehouseNumber = warehouseNumber;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "LogisticChannel [logisticGroupNumber=" + logisticGroupNumber + ", storeNumber=" + storeNumber
				+ ", streamNumber=" + streamNumber + ", startDate=" + startDate + ", warehouseNumber=" + warehouseNumber
				+ ", endDate=" + endDate + "]";
	}	
}
