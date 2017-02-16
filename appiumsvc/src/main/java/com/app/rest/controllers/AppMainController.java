package com.app.rest.controllers;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.mgr.RestRequestManager;
import com.app.web.vo.RegionDetailsVO;
import com.app.web.vo.VendorVO;
import com.app.web.wrapper.WrappedResponse;

@RestController
@RequestMapping("/services")
public class AppMainController {

	@Autowired
	private RestRequestManager restRequestManager;
	
	@RequestMapping(path="/getRegionDetails",method= RequestMethod.GET)
	public ResponseEntity<WrappedResponse<RegionDetailsVO>> getRegionDetails() {
		WrappedResponse<RegionDetailsVO> response = new WrappedResponse<>();
		response.setValid(true);
		RegionDetailsVO regionDetails = restRequestManager.getRegionDetails();
		response.setData(regionDetails);
		ResponseEntity<WrappedResponse<RegionDetailsVO>> resp = new ResponseEntity<WrappedResponse<RegionDetailsVO>>(response,HttpStatus.OK);
		return resp;
	}
	
	@RequestMapping(path="/createVendor",method=RequestMethod.POST)
	public Response createVendor(@RequestBody VendorVO vendorVO){
		System.out.println(vendorVO.getVendorName());
		return Response.ok().build();
	}

}
