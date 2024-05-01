package com.suarezr.orders_msvc.orderItem.services.dtos;


import com.suarezr.orders_msvc.order.services.dtos.UpdateOrderDto;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateOrderItemDto {

  private String id;

  private String productId;

  private Integer quantity;

  private UpdateOrderDto order;
}

  