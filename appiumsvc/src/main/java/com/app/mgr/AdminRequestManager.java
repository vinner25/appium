package com.app.mgr;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import com.app.web.vo.City;
import com.app.web.vo.Country;
import com.app.web.vo.VendorVO;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Component
public class AdminRequestManager {

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	
	public boolean createCountry(ObjectNode objectNode){
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		paramMap.addValue("name", objectNode.get("countryName").asText(),Types.VARCHAR);
		paramMap.addValue("region", objectNode.get("region").asText(),Types.VARCHAR);
		String sql = "insert into cleansmiles.country(name,region) values(:name,:region)";
		boolean response = namedParameterJdbcTemplate.update(sql, paramMap)==1?true:false;
		return response;
	}
	
	public boolean createCity(ObjectNode objectNode){
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		paramMap.addValue("name", objectNode.get("cityName").asText(),Types.VARCHAR);
		paramMap.addValue("countryid", objectNode.get("countryid").asInt(),Types.INTEGER);
		String sql = "insert into cleansmiles.city(name,countryid) values(:name,:countryid)";
		boolean response = namedParameterJdbcTemplate.update(sql, paramMap)==1?true:false;
		return response;
	}

	public boolean createLocalRegion(ObjectNode objectNode){
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		paramMap.addValue("regionname", objectNode.get("regionname").asText(),Types.VARCHAR);
		paramMap.addValue("streetname", objectNode.get("streetname").asText(),Types.VARCHAR);
		paramMap.addValue("pincode", objectNode.get("pincode").asText(),Types.CHAR);
		paramMap.addValue("cityid", objectNode.get("cityid").asInt(),Types.INTEGER);
		String sql = "insert into cleansmiles.regiondata(regionname,streetname,pincode,cityid) values(:regionname,:streetname,:pincode,:cityid)";
		boolean response = namedParameterJdbcTemplate.update(sql, paramMap)==1?true:false;
		return response;
	}
	
	public List<Country> getCountrList(){
		String sql = "select * from cleansmiles.country";
		SqlParameterSource paramMap = new MapSqlParameterSource();
		List<Map<String, Object>> countryData = namedParameterJdbcTemplate.queryForList(sql,paramMap);
		List<Country> countries = new ArrayList<>();
		Consumer<? super Map<String, Object>> action = i -> createData(i, countries);
		countryData.forEach(action);
		return countries;
	}
	
	public static void createData(Map<String,Object> data, List<Country> countryList){
		Integer id = (Integer) data.get("id");
		String name = (String) data.get("name");
		Country country = new Country();
		country.setId(id);
		country.setCountryName(name);
		countryList.add(country);
	}
	
	public static void createCityData(Map<String,Object> data, List<City> cityList){
		Integer id = (Integer) data.get("id");
		String name = (String) data.get("name");
		City city = new City();
		city.setId(id);
		city.setCityName(name);
		cityList.add(city);
	}
	
	public static void createVendorData(Map<String,Object> data, List<VendorVO> vendorData){
		Integer id = (Integer) data.get("id");
		String name = (String) data.get("name");
		boolean pickAvail = (boolean) data.get("pickavail");
		VendorVO vo = new VendorVO();
		vo.setPickUpAvailable(pickAvail);
		vo.setVendorName(name);
		vo.setId(id);
		vendorData.add(vo);
	}
	
	public List<City> getCitiesByCountry(int id){
		String sql = "select * from cleansmiles.city where countryid=:id";
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		paramMap.addValue("id", id);
		List<Map<String, Object>> cityData = namedParameterJdbcTemplate.queryForList(sql,paramMap);
		List<City> citiesList = new ArrayList<>();
		Consumer<? super Map<String, Object>> action = i -> createCityData(i, citiesList);
		cityData.forEach(action);
		return citiesList;
	}
	
	public List<VendorVO> getVendorsByCity(int id){
		String sql = "select * from cleansmiles.vendordata where cityid=:id";
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		paramMap.addValue("id", id);
		List<Map<String, Object>> cityData = namedParameterJdbcTemplate.queryForList(sql,paramMap);
		List<VendorVO> vendorList = new ArrayList<>();
		Consumer<? super Map<String, Object>> action = i -> createVendorData(i, vendorList);
		cityData.forEach(action);
		return vendorList;
	}
	
	
}
