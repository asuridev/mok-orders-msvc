package com.suarezr.orders_msvc.orderItem.services.dtos;

import com.suarezr.orders_msvc.order.services.dtos.CreateOrderDto;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateOrderItemDto {

  private String id;

  private String productId;

  private Integer quantity;

  private CreateOrderDto order;
     
}

  