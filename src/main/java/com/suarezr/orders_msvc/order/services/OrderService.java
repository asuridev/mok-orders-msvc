package com.suarezr.orders_msvc.order.services;

import com.suarezr.orders_msvc.order.persistence.entities.OrderEntity;
import com.suarezr.orders_msvc.order.services.dtos.*;
import com.suarezr.orders_msvc.orderItem.services.OrderItemService;
import com.suarezr.orders_msvc.orderItem.services.dtos.CreateOrderItemDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderServiceRepository orderServiceRepository;
    private final ConverterOrderDto converterOrderDto;
    private final OrderItemService orderItemService;

    public ResponseOrderDto create(NewOrderDto newOrderDto){
       CreateOrderDto createOrderDto = this.generateOrder(newOrderDto);
       OrderDto order = orderServiceRepository.createOrder(createOrderDto);
       createOrderDto.setId(order.getId());
       this.addItems(newOrderDto, createOrderDto);
       return this.converterOrderDto.toResponseOrderDto(order);
    }

    public Page<OrderEntity> findAll(int page, int limit, String sortBy){
       return orderServiceRepository.findAllOrders(page, limit ,sortBy);

    }

    public OrderEntity findOne(String id){
        return orderServiceRepository.findOneOrder(id).orElse(null);

    }

    public OrderEntity update(UpdateOrderDto updateOrderDto, String id){
        return orderServiceRepository.updateOrder(updateOrderDto, id).orElse(null);

    }

    public void remove(String id){
        this.findOne(id);
        orderServiceRepository.removeOrder(id);
    }

    private CreateOrderDto generateOrder(NewOrderDto newOrderDto){
       return new CreateOrderDto(
                null,
                newOrderDto.getOwner(),
                newOrderDto.getAddress(),
                newOrderDto.getState()
        );
    }

    private void addItems(NewOrderDto newOrderDto, CreateOrderDto createOrderDto){
        newOrderDto.getItems().forEach(item ->{
            CreateOrderItemDto orderItem = new CreateOrderItemDto(
                    null,
                    item.getProductId(),
                    item.getQuantity(),
                    createOrderDto
            );
            this.orderItemService.create(orderItem);
        });
    }
}

  