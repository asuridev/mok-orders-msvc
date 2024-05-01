package com.suarezr.orders_msvc.orderItem.services.dtos;

import com.suarezr.orders_msvc.order.services.dtos.OrderDto;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItemDto {

  private String id;

  private String productId;

  private Integer quantity;

  private OrderDto order;

}

  