package com.suarezr.orders_msvc.orderItem.services;

import com.suarezr.orders_msvc.common.exceptions.NotFoundException;
import com.suarezr.orders_msvc.orderItem.services.dtos.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class OrderItemService {

    private final OrderItemServiceRepository orderItemServiceRepository;
    private final ConverterOrderItemDto converterOrderItemDto;

    public ResponseOrderItemDto create(CreateOrderItemDto createOrderItemDto){
        OrderItemDto orderItem = orderItemServiceRepository.createOrderItem(createOrderItemDto);
        return this.converterOrderItemDto.toResponseOrderItemDto(orderItem);
    }

    public Page<ResponseOrderItemDto> findAll(int page, int limit, String sortBy){
        Page<OrderItemDto> orderItems = orderItemServiceRepository.findAllOrderItems(page, limit ,sortBy);
        System.out.println(orderItems);
        return  orderItems.map(converterOrderItemDto::toResponseOrderItemDto);
    }

    public ResponseOrderItemDto findOne(String id){
        OrderItemDto orderItem = orderItemServiceRepository.findOneOrderItem(id).orElseThrow(NotFoundException::new);
        return this.converterOrderItemDto.toResponseOrderItemDto(orderItem);
    }

    public ResponseOrderItemDto update(UpdateOrderItemDto updateOrderItemDto, String id){
        OrderItemDto orderItem = orderItemServiceRepository.updateOrderItem(updateOrderItemDto, id).orElseThrow(NotFoundException::new);
        return this.converterOrderItemDto.toResponseOrderItemDto(orderItem);
    }

    public void remove(String id){
        this.findOne(id);
        orderItemServiceRepository.removeOrderItem(id);
    }
}

  