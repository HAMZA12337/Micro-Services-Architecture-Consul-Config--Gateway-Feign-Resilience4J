package org.sid.customerservuce.entities;


import org.springframework.data.rest.core.config.Projection;

@Projection(name="fullCustomer",types = Customer.class)
public interface CustomerProjection {

    public int getId();
    public String getName();
    public String getEmail();



}
