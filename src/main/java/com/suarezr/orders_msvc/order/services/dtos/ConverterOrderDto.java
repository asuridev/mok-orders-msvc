package com.suarezr.orders_msvc.order.services.dtos;


import com.suarezr.orders_msvc.orderItem.services.dtos.ResponseOrderItemDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ConverterOrderDto {

    @Mappings({

    })
    ResponseOrderDto toResponseOrderDto(OrderDto orderDto);

    List<ResponseOrderDto> toResponseOrderDtoList(List<OrderDto> orderDtoList);
}
  