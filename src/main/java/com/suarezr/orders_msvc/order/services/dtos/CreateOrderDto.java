package com.suarezr.orders_msvc.order.services.dtos;

import lombok.*;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateOrderDto {
  private String id;

  private String owner;

  private String address;

  private String state;
  
}

  