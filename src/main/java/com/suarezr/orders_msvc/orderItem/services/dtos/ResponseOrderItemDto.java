package com.suarezr.orders_msvc.orderItem.services.dtos;

import com.suarezr.orders_msvc.order.services.dtos.ResponseOrderDto;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseOrderItemDto {
  private String id;

  private String productId;

  private Integer quantity;

  private ResponseOrderDto order;
}

  