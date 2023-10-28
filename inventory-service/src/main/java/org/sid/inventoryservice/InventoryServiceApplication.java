package org.sid.inventoryservice;

import org.sid.inventoryservice.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.sid.inventoryservice.entities.Product;

import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}


@Bean
	CommandLineRunner start(ProductRepository productRepository){

		return args -> {

			productRepository.saveAll(List.of(

					    Product.builder().name("HP").price(12).quantity(2121).build(),
						Product.builder().name("DELLE").price(13).quantity(2121).build(),
						Product.builder().name("MAC").price(321).quantity(34444).build()

			));


			// GET aLL products

                 productRepository.findAll().forEach(System.out::println);


		};
}









}

