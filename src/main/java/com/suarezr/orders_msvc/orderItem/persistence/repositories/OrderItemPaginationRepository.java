package com.suarezr.orders_msvc.orderItem.persistence.repositories;


import com.suarezr.orders_msvc.orderItem.persistence.entities.OrderItemEntity;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface OrderItemPaginationRepository extends PagingAndSortingRepository <OrderItemEntity,String>{


}

  