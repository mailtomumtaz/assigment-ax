package com.asg.cxiom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration.class})
public class CxiomApplication {

	public static void main(String[] args) {

		SpringApplication.run(CxiomApplication.class, args);
	}

}
