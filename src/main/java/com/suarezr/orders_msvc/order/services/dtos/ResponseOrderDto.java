package com.suarezr.orders_msvc.order.services.dtos;

import com.suarezr.orders_msvc.orderItem.persistence.entities.OrderItemEntity;
import com.suarezr.orders_msvc.orderItem.services.dtos.ResponseOrderItemDto;
import lombok.*;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseOrderDto {
  private String id;

  private String owner;

  private String address;

  private String state;
  List<ResponseOrderItemDto> orderItem;
}

  