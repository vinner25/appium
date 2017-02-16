package com.app.web.vo;

import java.util.List;

import com.app.web.bo.Vendor;

public class RegionDetailsVO {

	private String regionName;
	private String regionId;
	private List<Vendor> vendors;
	
	/**
	 * @return the regionName
	 */
	public String getRegionName() {
		return regionName;
	}
	/**
	 * @param regionName the regionName to set
	 */
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	/**
	 * @return the regionId
	 */
	public String getRegionId() {
		return regionId;
	}
	/**
	 * @param regionId the regionId to set
	 */
	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}
	
	/**
	 * @return the vendors
	 */
	public List<Vendor> getVendors() {
		return vendors;
	}
	/**
	 * @param vendors the vendors to set
	 */
	public void setVendors(List<Vendor> vendors) {
		this.vendors = vendors;
	}
	
}
