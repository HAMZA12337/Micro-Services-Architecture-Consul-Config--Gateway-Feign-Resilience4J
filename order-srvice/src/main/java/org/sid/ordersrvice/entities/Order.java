package org.sid.ordersrvice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.ordersrvice.enums.OrderStatus;
import org.sid.ordersrvice.model.Customer;

import java.util.Date;
import java.util.List;


@Entity @Data
@Table(name="orders")
@AllArgsConstructor @NoArgsConstructor @Builder
public class Order {


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private Date createdAt;

    private OrderStatus status;

    private Long CustomerId;

    @Transient

    private Customer customer ;

    @OneToMany(mappedBy = "order")

    private List<ProductItem> productItems;




}
