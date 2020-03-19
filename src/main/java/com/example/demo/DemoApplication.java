package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


	@GetMapping("/hello")
	public String hello(){

		return "{\n" +
				"    \"code\": 200,\n" +
				"    \"data\": \"hello\",\n" +
				"    \"message\": \"请求成功over8\"\n" +
				"}";
	}

}
