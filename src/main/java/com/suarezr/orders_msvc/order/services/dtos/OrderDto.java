package com.suarezr.orders_msvc.order.services.dtos;

import com.suarezr.orders_msvc.orderItem.services.dtos.OrderItemDto;
import lombok.*;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDto {

  private String id;

  private String owner;

  private String address;

  private String state;


}

  