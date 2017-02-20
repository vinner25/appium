package com.app.mgr;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.app.web.bo.Vendor;
import com.app.web.vo.RegionDetailsVO;
import com.app.web.vo.VendorVO;

@Component
public class RestRequestManager {

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public RegionDetailsVO getRegionDetails() {
		RegionDetailsVO regionDetailsVO = new RegionDetailsVO();
		regionDetailsVO.setRegionId("1");
		regionDetailsVO.setRegionName("ONE");
		String sql = "select id,vendorname,areaid from cleansmiles.vendorlist";
		Map<String,Object> dataMap = new HashMap<>(); 
		try {
			List<Vendor> vendorList = (List<Vendor>) namedParameterJdbcTemplate.query(sql, dataMap, new RowMapper<Vendor>() {

				@Override
				public Vendor mapRow(ResultSet rs, int rowNum) throws SQLException {
					Vendor vend = new Vendor();
					vend.setId(rs.getInt("id"));
					vend.setVendorname(rs.getString("vendorname"));
					vend.setAreaid(rs.getInt("areaid"));
					return vend;
				}
			});
			
			regionDetailsVO.setVendors(vendorList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return regionDetailsVO;
	}
	
	public boolean createVendor(VendorVO vendorData){
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("name", vendorData.getVendorName(), Types.VARCHAR);
		paramSource.addValue("pan", vendorData.getVendorPAN(), Types.VARCHAR);
		paramSource.addValue("city", vendorData.getCity(), Types.VARCHAR);
		paramSource.addValue("pickcount", vendorData.getPickUpCounts(), Types.INTEGER);
		paramSource.addValue("pickavail", vendorData.isPickUpAvailable(), Types.BOOLEAN);
		paramSource.addValue("emailid", vendorData.getEmailId(), Types.VARCHAR);
		paramSource.addValue("cityid", vendorData.getCityId(), Types.INTEGER);
		String sql = "insert into cleansmiles.vendordata(name,pan,city,pickcount,pickavail,emailid,cityid) values(:name,:pan,:city,:pickcount,:pickavail,:emailid,:cityid)";
		int update = namedParameterJdbcTemplate.update(sql, paramSource);
		return update==1?true:false;
	}
	
}
