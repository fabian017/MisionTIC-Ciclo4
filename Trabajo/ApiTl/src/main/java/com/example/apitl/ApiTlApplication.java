package com.example.apitl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin("*")
public class ApiTlApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiTlApplication.class, args);
	}

}
