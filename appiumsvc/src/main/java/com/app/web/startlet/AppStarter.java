package com.app.web.startlet;

import org.springframework.boot.SpringApplication;

import com.app.web.config.AppConfig;

public class AppStarter {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(AppConfig.class, args);
	}

}
