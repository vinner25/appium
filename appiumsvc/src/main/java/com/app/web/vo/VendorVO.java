package com.app.web.vo;

import java.io.Serializable;

public class VendorVO implements Serializable{
	private String vendorName;
	private String vendorPAN;
	private String city;
	private int pickUpCounts;
	private boolean isPickUpAvailable;
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public String getVendorPAN() {
		return vendorPAN;
	}
	public void setVendorPAN(String vendorPAN) {
		this.vendorPAN = vendorPAN;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPickUpCounts() {
		return pickUpCounts;
	}
	public void setPickUpCounts(int pickUpCounts) {
		this.pickUpCounts = pickUpCounts;
	}
	public boolean isPickUpAvailable() {
		return isPickUpAvailable;
	}
	public void setPickUpAvailable(boolean isPickUpAvailable) {
		this.isPickUpAvailable = isPickUpAvailable;
	}
	
}