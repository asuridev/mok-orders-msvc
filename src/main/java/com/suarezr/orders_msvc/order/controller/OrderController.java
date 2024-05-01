package com.suarezr.orders_msvc.order.controller;

import com.suarezr.orders_msvc.common.dtos.PaginationDto;
import com.suarezr.orders_msvc.common.dtos.PathParamDto;
import com.suarezr.orders_msvc.common.nats.NatsClient;
import com.suarezr.orders_msvc.common.nats.StatusCode;
import com.suarezr.orders_msvc.order.persistence.entities.OrderEntity;
import com.suarezr.orders_msvc.order.services.OrderService;
import com.suarezr.orders_msvc.order.services.dtos.NewOrderDto;
import com.suarezr.orders_msvc.order.services.dtos.UpdateOrderDto;
import com.suarezr.orders_msvc.order.services.dtos.ResponseOrderDto;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;


@RequiredArgsConstructor
@Controller
public class OrderController {

    private final OrderService orderService;
    private final NatsClient natsClient;

    @PostConstruct
    void start(){

        this.natsClient.createDispatcher().subscribe("order.create", (msg)->{
            NewOrderDto newOrderDto = this.natsClient.toJava(msg,NewOrderDto.class);
            ResponseOrderDto responseOrderDto = this.orderService.create(newOrderDto);
            this.natsClient.reply(msg, responseOrderDto);
        });

        this.natsClient.createDispatcher().subscribe("order.read", (msg)->{
            PaginationDto paginationDto = this.natsClient.toJava(msg, PaginationDto.class);
            Page<OrderEntity> pageResponse = this.orderService.findAll(paginationDto.getPage(), paginationDto.getLimit(),paginationDto.getSortBy());
            this.natsClient.reply(msg, pageResponse.stream().toList());
        });

        this.natsClient.createDispatcher().subscribe("order.read_by_id", (msg)->{
            PathParamDto pathParamDto = this.natsClient.toJava(msg, PathParamDto.class);
            OrderEntity responseOrderDto =  this.orderService.findOne(pathParamDto.getId());
            if(responseOrderDto == null) {
                this.natsClient.rpcException(msg, StatusCode.NOT_FOUND, "Order Not Found");
                return;
            }
            this.natsClient.reply(msg, responseOrderDto);
        });

        this.natsClient.createDispatcher().subscribe("order.update", (msg)->{
            UpdateOrderDto updateOrderDto = this.natsClient.toJava(msg, UpdateOrderDto.class);
            OrderEntity responseOrderDto =  this.orderService.update(updateOrderDto, updateOrderDto.getId());
            if(responseOrderDto == null) {
                this.natsClient.rpcException(msg, StatusCode.NOT_FOUND, "Order not Found");
                return;
            }
            this.natsClient.reply(msg, responseOrderDto);
        });

    }

}

  