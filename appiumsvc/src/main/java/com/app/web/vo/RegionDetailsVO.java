package com.app.web.vo;

import java.util.List;

public class RegionDetailsVO {

	private String regionName;
	private String regionId;
	private List<String> vendorList;
	
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
	 * @return the vendorList
	 */
	public List<String> getVendorList() {
		return vendorList;
	}
	/**
	 * @param vendorList the vendorList to set
	 */
	public void setVendorList(List<String> vendorList) {
		this.vendorList = vendorList;
	}
	
}
