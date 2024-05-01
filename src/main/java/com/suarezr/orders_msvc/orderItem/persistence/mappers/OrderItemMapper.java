package com.suarezr.orders_msvc.orderItem.persistence.mappers;

import com.suarezr.orders_msvc.order.persistence.mappers.OrderMapper;
import com.suarezr.orders_msvc.orderItem.persistence.entities.OrderItemEntity;
import com.suarezr.orders_msvc.orderItem.services.dtos.CreateOrderItemDto;
import com.suarezr.orders_msvc.orderItem.services.dtos.UpdateOrderItemDto;
import com.suarezr.orders_msvc.orderItem.services.dtos.OrderItemDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,uses = {OrderMapper.class})
public interface OrderItemMapper {

    ////////////////Entity -> Dto////////////////
    @Mappings({

    })
    OrderItemDto toOrderItemDto(OrderItemEntity orderItemEntity);


    ////////////////CreateDto -> Entity////////////////
    @Mappings({
           
    })
    OrderItemEntity toOrderItemEntity(CreateOrderItemDto createOrderItemDto);

    ////////////////UpdateDto -> Entity////////////////
    @Mappings({
          
    })
    OrderItemEntity toOrderItemEntity(UpdateOrderItemDto updateOrderItemDto);

    ////////////Merge Entity with Dto////////////
    @Mappings({
            
    })
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    OrderItemEntity merge(UpdateOrderItemDto updateOrderItemDto, @MappingTarget OrderItemEntity orderItemEntity);

    /////////////list Entity-> list Dto////////////
    List<OrderItemDto> toOrderItemDtoList(List<OrderItemEntity> orderItemEntityList);
    
    /////////////listCreateDto -> list Entity////////////
    List<OrderItemEntity> toOrderItemEntityList(List<CreateOrderItemDto> createOrderItemDtos);

    /////////////listUpdateDto -> list Entity////////////
    List<OrderItemEntity> toOrderItemEntityListUpdate(List<UpdateOrderItemDto> updateOrderItemDtos);

}

  