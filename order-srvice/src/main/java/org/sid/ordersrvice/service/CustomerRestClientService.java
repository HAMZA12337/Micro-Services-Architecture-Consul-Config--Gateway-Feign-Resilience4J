package org.sid.ordersrvice.service;

import org.sid.ordersrvice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="customer-service")
public interface CustomerRestClientService {


   // Without id
//    @GetMapping(path="/customers/{id}")
//    public Customer customerById(@PathVariable(name="id") Long id);

    @GetMapping(path="/customers/{id}?projection=fullCustomer")
    public Customer customerById(@PathVariable(name="id") Long id);

    @GetMapping(path="/customers?projection=fullCustomer")
    public PagedModel<Customer> allcustomers();


}
