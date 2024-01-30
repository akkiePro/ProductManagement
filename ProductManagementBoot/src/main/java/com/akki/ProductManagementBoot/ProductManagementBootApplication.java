package com.akki.ProductManagementBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ProductManagementBootApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ProductManagementBootApplication.class, args);
		ProductService service = context.getBean(ProductService.class);
		service.displayAllProducts();
	}

}
