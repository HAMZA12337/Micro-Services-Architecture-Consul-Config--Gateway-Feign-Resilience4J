package org.sid.customerservuce;

import org.sid.customerservuce.entities.Customer;
import org.sid.customerservuce.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CustomerServuceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServuceApplication.class, args);
	}



	@Bean

	CommandLineRunner start(CustomerRepository customerRepository){

		return args->{

			customerRepository.saveAll(
					List.of(

							Customer.builder().name("BRAIMI").email("Hamza@gmail.com").build(),
							Customer.builder().name("Karim").email("karim@gmail.com").build(),
							Customer.builder().name("Hassam").email("Hasaa@gmail.com").build(),
							Customer.builder().name("Ahmadi").email("ahmadia@gmail.com").build()
					)
			);


              customerRepository.findAll().forEach(System.out::println);


		};
	}











}


