package com.shafayat.vendor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class VendorApplication {

	public static void main(String[] args) {

		Dotenv dotenv = Dotenv.configure().directory("./vendor-springboot").ignoreIfMissing().load();

		dotenv.entries().forEach(entry -> System.setProperty(entry.getKey(), entry.getValue()));

		SpringApplication.run(VendorApplication.class, args);
	}

}
