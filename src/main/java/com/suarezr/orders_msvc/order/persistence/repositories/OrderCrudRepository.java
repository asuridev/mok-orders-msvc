package com.suarezr.orders_msvc.order.persistence.repositories;


import com.suarezr.orders_msvc.order.persistence.entities.OrderEntity;
import org.springframework.data.repository.CrudRepository;


public interface OrderCrudRepository extends CrudRepository <OrderEntity,String>{


}

  