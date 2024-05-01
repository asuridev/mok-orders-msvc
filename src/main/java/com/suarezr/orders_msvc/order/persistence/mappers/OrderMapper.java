package com.suarezr.orders_msvc.order.persistence.mappers;

import com.suarezr.orders_msvc.order.persistence.entities.OrderEntity;
import com.suarezr.orders_msvc.order.services.dtos.CreateOrderDto;
import com.suarezr.orders_msvc.order.services.dtos.UpdateOrderDto;
import com.suarezr.orders_msvc.order.services.dtos.OrderDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderMapper {

    ////////////////Entity -> Dto////////////////
    @Mappings({

    })
    OrderDto toOrderDto(OrderEntity orderEntity);


    ////////////////CreateDto -> Entity////////////////
    @Mappings({
           
    })
    OrderEntity toOrderEntity(CreateOrderDto createOrderDto);

    ////////////////UpdateDto -> Entity////////////////
    @Mappings({
          
    })
    OrderEntity toOrderEntity(UpdateOrderDto updateOrderDto);

    ////////////Merge Entity with Dto////////////
    @Mappings({
            
    })
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    OrderEntity merge(UpdateOrderDto updateOrderDto, @MappingTarget OrderEntity orderEntity);

    /////////////list Entity-> list Dto////////////
    List<OrderDto> toOrderDtoList(List<OrderEntity> orderEntityList);
    
    /////////////listCreateDto -> list Entity////////////
    List<OrderEntity> toOrderEntityList(List<CreateOrderDto> createOrderDtos);

    /////////////listUpdateDto -> list Entity////////////
    List<OrderEntity> toOrderEntityListUpdate(List<UpdateOrderDto> updateOrderDtos);

}

  