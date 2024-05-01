package com.suarezr.orders_msvc.orderItem.controller;

import com.suarezr.orders_msvc.orderItem.services.OrderItemService;
import com.suarezr.orders_msvc.orderItem.services.dtos.CreateOrderItemDto;
import com.suarezr.orders_msvc.orderItem.services.dtos.UpdateOrderItemDto;
import com.suarezr.orders_msvc.orderItem.services.dtos.ResponseOrderItemDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("order-item")
public class OrderItemController {

    private final OrderItemService orderItemService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseOrderItemDto create(@Valid @RequestBody CreateOrderItemDto createOrderItemDto){
       return  this.orderItemService.create(createOrderItemDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public Page<ResponseOrderItemDto> findAll(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false,defaultValue = "100") int limit,
            @RequestParam(required = false,defaultValue = "id") String sortBy
    ){
        return this.orderItemService.findAll(page, limit, sortBy);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public ResponseOrderItemDto findOne(@PathVariable("id") String id){
        return this.orderItemService.findOne(id);
    }
    
    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/{id}")
    public ResponseOrderItemDto update(@Valid @RequestBody UpdateOrderItemDto updateOrderItemDto, @PathVariable("id") String id){
        return this.orderItemService.update(updateOrderItemDto, id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void remove(@PathVariable("id") String id){
        this.orderItemService.remove(id);
    }

}

  