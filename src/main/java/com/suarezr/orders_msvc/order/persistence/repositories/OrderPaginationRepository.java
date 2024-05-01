package com.suarezr.orders_msvc.order.persistence.repositories;


import com.suarezr.orders_msvc.order.persistence.entities.OrderEntity;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface OrderPaginationRepository extends PagingAndSortingRepository <OrderEntity,String>{


}

  