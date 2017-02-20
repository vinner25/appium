package com.app.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.mgr.AdminRequestManager;
import com.app.web.vo.City;
import com.app.web.vo.Country;
import com.app.web.vo.VendorVO;
import com.app.web.wrapper.WrappedResponse;
import com.fasterxml.jackson.databind.node.ObjectNode;

@RestController
@RequestMapping("/adminsvc")
public class AppAdminController {

	@Autowired
	private AdminRequestManager adminRequestManager;

	@RequestMapping(path="/createCountry", method=RequestMethod.POST)
	public ResponseEntity<WrappedResponse<Boolean>> createCountry(@RequestBody ObjectNode objectNode){
		WrappedResponse<Boolean> body = new WrappedResponse<>();
		boolean createCountry = adminRequestManager.createCountry(objectNode);
		body.setData(createCountry);
		body.setValid(createCountry);
		ResponseEntity<WrappedResponse<Boolean>> responseEntity = new ResponseEntity<WrappedResponse<Boolean>>(body,HttpStatus.OK);
		return responseEntity;
	}
	
	@RequestMapping(path="/createCity", method=RequestMethod.POST)
	public ResponseEntity<WrappedResponse<Boolean>> createCity(@RequestBody ObjectNode objectNode){
		WrappedResponse<Boolean> body = new WrappedResponse<>();
		boolean createCountry = adminRequestManager.createCity(objectNode);
		body.setData(createCountry);
		body.setValid(createCountry);
		ResponseEntity<WrappedResponse<Boolean>> responseEntity = new ResponseEntity<WrappedResponse<Boolean>>(body,HttpStatus.OK);
		return responseEntity;
	}
	
	@RequestMapping(path="/getCountries", method=RequestMethod.GET)
	public ResponseEntity<WrappedResponse<?>> fetchCountries(){
		List<Country> countrList = adminRequestManager.getCountrList();
		WrappedResponse<List<Country>> body = new WrappedResponse<>();
		body.setData(countrList);
		ResponseEntity<WrappedResponse<?>> response = new ResponseEntity<WrappedResponse<?>>(body, HttpStatus.OK);
		return response;
	}
	
	@RequestMapping(path="/getCitiesByCountry", method=RequestMethod.GET)
	public ResponseEntity<WrappedResponse<?>> getCitiesByCountry(@RequestParam("id") int countryId){
		List<City> cityList = adminRequestManager.getCitiesByCountry(countryId);
		WrappedResponse<List<City>> body = new WrappedResponse<>();
		body.setData(cityList);
		ResponseEntity<WrappedResponse<?>> response = new ResponseEntity<WrappedResponse<?>>(body, HttpStatus.OK);
		return response;
	}
	
	@RequestMapping(path="/getVendorsByCity", method=RequestMethod.GET)
	public ResponseEntity<WrappedResponse<?>> getVendorsByCity(@RequestParam("id") int cityId){
		List<VendorVO> vendorData = adminRequestManager.getVendorsByCity(cityId);
		WrappedResponse<List<VendorVO>> body = new WrappedResponse<>();
		body.setData(vendorData);
		ResponseEntity<WrappedResponse<?>> response = new ResponseEntity<WrappedResponse<?>>(body, HttpStatus.OK);
		return response;
	}
	
	
	
}
