package com.mvc.diary;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties ("diary")
@SpringBootApplication(exclude = SecurityAutoConfiguration.class) 
public class DiaryApplication {
	@Value ("{mongodbname}")
	public static String dbname;
	public static void main(String[] args) {
		SpringApplication.run(DiaryApplication.class, args);
		System.out.println("dbname  " + dbname);

	}
	



}
