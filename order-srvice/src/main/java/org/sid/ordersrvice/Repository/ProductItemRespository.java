package org.sid.ordersrvice.Repository;

import org.sid.ordersrvice.entities.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface ProductItemRespository extends JpaRepository<ProductItem,Long> {





}
