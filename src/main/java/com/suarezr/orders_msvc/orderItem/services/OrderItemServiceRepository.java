package com.suarezr.orders_msvc.orderItem.services;

import com.suarezr.orders_msvc.orderItem.services.dtos.CreateOrderItemDto;
import com.suarezr.orders_msvc.orderItem.services.dtos.UpdateOrderItemDto;
import com.suarezr.orders_msvc.orderItem.services.dtos.OrderItemDto;
import org.springframework.data.domain.Page;
import java.util.Optional;

public interface OrderItemServiceRepository {

    public OrderItemDto createOrderItem(CreateOrderItemDto createOrderItemDto);

    public Page<OrderItemDto> findAllOrderItems(int page, int limit, String sortBy);

    public Optional<OrderItemDto> findOneOrderItem(String id);

    public Optional<OrderItemDto> updateOrderItem(UpdateOrderItemDto updateOrderItemDto, String id);

    public void removeOrderItem(String id);
}

  