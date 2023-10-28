package org.sid.ordersrvice.web;


import org.sid.ordersrvice.Repository.OrderRespository;
import org.sid.ordersrvice.Repository.ProductItemRespository;
import org.sid.ordersrvice.entities.Order;
import org.sid.ordersrvice.model.Product;
import org.sid.ordersrvice.service.CustomerRestClientService;
import org.sid.ordersrvice.service.InventoryRestClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderRestController {


    private OrderRespository orderRespository;
    private ProductItemRespository productItemRespository;
    private CustomerRestClientService customerRestClientService;
    private InventoryRestClientService inventoryRestClientService;

    public OrderRestController(OrderRespository orderRespository, ProductItemRespository productItemRespository, CustomerRestClientService customerRestClientService, InventoryRestClientService inventoryRestClientService) {
        this.orderRespository = orderRespository;
        this.productItemRespository = productItemRespository;
        this.customerRestClientService = customerRestClientService;
        this.inventoryRestClientService = inventoryRestClientService;
    }


    @GetMapping("/fullOrder/{id}")

    public Order getOrder(@PathVariable(name="id") Long id){

        Order order=orderRespository.findById(id).get();

        order.setCustomer(customerRestClientService.customerById(order.getCustomerId()));
        order.getProductItems().forEach(pi->{
            Product product=inventoryRestClientService.productsById(pi.getProductId());
            pi.setProduct(product);
        });

    return order;}





}
