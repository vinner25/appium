package com.app.web.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.web.vo.RegionDetailsVO;
import com.app.web.wrapper.WrappedResponse;

@RestController
@RequestMapping("/services")
public class AppMainController {

	@Autowired NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@RequestMapping(path="/getRegionDetails",method= RequestMethod.GET)
	public ResponseEntity<WrappedResponse<RegionDetailsVO>> getRegionDetails() {
		RegionDetailsVO regionDetailsVO = new RegionDetailsVO();
		regionDetailsVO.setRegionId("1");
		regionDetailsVO.setRegionName("ONE");
		regionDetailsVO.setVendorList(new ArrayList<String>());
		/*regionDetailsVO.getVendorList().add("Alpha");
		regionDetailsVO.getVendorList().add("Beta");
		regionDetailsVO.getVendorList().add("Gamma");*/
		WrappedResponse<RegionDetailsVO> response = new WrappedResponse<>();
		response.setData(regionDetailsVO);
		response.setValid(true);
		SqlParameterSource paramMap = new MapSqlParameterSource();
		String sql = "select vendorname from cleansmiles.vendorlist";
		List<String> vendorNames = namedParameterJdbcTemplate.queryForList(sql, paramMap, String.class);
		regionDetailsVO.getVendorList().addAll(vendorNames);
		ResponseEntity<WrappedResponse<RegionDetailsVO>> resp = new ResponseEntity<WrappedResponse<RegionDetailsVO>>(response,HttpStatus.OK);
		return resp;
	}

}
