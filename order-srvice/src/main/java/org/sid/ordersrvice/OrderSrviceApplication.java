package org.sid.ordersrvice;

import org.sid.ordersrvice.Repository.OrderRespository;
import org.sid.ordersrvice.Repository.ProductItemRespository;
import org.sid.ordersrvice.entities.Order;
import org.sid.ordersrvice.entities.ProductItem;
import org.sid.ordersrvice.enums.OrderStatus;
import org.sid.ordersrvice.model.Customer;
import org.sid.ordersrvice.model.Product;
import org.sid.ordersrvice.service.CustomerRestClientService;
import org.sid.ordersrvice.service.InventoryRestClientService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class OrderSrviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderSrviceApplication.class, args);
	}


	@Bean
	CommandLineRunner start(OrderRespository orderRespository, ProductItemRespository productItemRespository,
							CustomerRestClientService customerRestClientService,
							InventoryRestClientService inventoryRestClientService){


		return args -> {


			List<Customer> customers=customerRestClientService.allcustomers().getContent().stream().toList();
			List<Product> products=inventoryRestClientService.allproducts().getContent().stream().toList();

			Long customerId=1L;
           Random random=new Random();
			Customer customer=customerRestClientService.customerById(customerId);

			for(int i=0;i<20;i++ ){
				Order order=Order.builder()
						.CustomerId(customers.get(random.nextInt(customers.size())).getId())
						.status(Math.random()>0.5?OrderStatus.PENDING:OrderStatus.CREATED)
						.createdAt(new Date())
						.build();


				Order savedOrder=orderRespository.save(order);


				for(int j=0;j<products.size();j++) {

					if (Math.random() > 0.5) {
						ProductItem productItem = ProductItem.builder()
								.order(savedOrder)
								.ProductId(products.get(j).getId())
								.price(products.get(j).getPrice())
								.quantity(products.get(j).getQuantity())
								.discount(Math.random())
								.build();
						productItemRespository.save(productItem);
					}
				}



			}






		};





	}












}
