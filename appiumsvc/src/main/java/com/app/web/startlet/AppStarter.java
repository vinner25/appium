package com.app.web.startlet;

import org.springframework.boot.SpringApplication;

import com.app.web.config.AppConfig;
import com.app.web.vo.VendorVO;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AppStarter {
	public static void main(String[] args) throws Exception {
		//printJSON();
		SpringApplication.run(AppConfig.class, args);
	}
	
	public static void printJSON(){
		ObjectMapper om = new ObjectMapper();
		VendorVO vvo = new VendorVO();
		vvo.setCity("A");
		vvo.setPickUpAvailable(true);
		vvo.setVendorPAN("BVQPB");
		vvo.setPickUpCounts(2);
		vvo.setVendorName("Alpha");
		try {
			boolean canSerialize = om.canSerialize(VendorVO.class);
			System.out.println(canSerialize);
			System.out.println(om.writeValueAsString(vvo));
			//System.out.println(om.writeValueAsString(om));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
