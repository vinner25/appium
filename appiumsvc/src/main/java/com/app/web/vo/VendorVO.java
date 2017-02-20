package com.app.web.vo;

import java.io.Serializable;

public class VendorVO implements Serializable{
	/**
	 * 
	 */
	private int id;
	private static final long serialVersionUID = 1L;
	private String vendorName;
	private String vendorPAN;
	private String city;
	private int pickUpCounts;
	private boolean isPickUpAvailable;
	private String emailId;
	private int cityId;
	
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
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}