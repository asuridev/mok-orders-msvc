package com.suarezr.orders_msvc.order.services;

import com.suarezr.orders_msvc.order.persistence.entities.OrderEntity;
import com.suarezr.orders_msvc.order.services.dtos.CreateOrderDto;
import com.suarezr.orders_msvc.order.services.dtos.UpdateOrderDto;
import com.suarezr.orders_msvc.order.services.dtos.OrderDto;
import org.springframework.data.domain.Page;
import java.util.Optional;

public interface OrderServiceRepository {

    public OrderDto createOrder(CreateOrderDto createOrderDto);

    public Page<OrderEntity> findAllOrders(int page, int limit, String sortBy);

    public Optional<OrderEntity> findOneOrder(String id);

    public Optional<OrderEntity> updateOrder(UpdateOrderDto updateOrderDto, String id);

    public void removeOrder(String id);
}

  