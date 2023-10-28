package org.sid.ordersrvice.service;

import org.sid.ordersrvice.model.Customer;
import org.sid.ordersrvice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="inventory-service")
public interface InventoryRestClientService {


    @GetMapping(path="/products/{id}?projection=fullProduct")
    public Product productsById(@PathVariable(name="id") Long id);

    @GetMapping(path="/products?projection=fullProduct")
    public PagedModel<Product> allproducts();


}
