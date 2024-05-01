package com.suarezr.orders_msvc.order.services.dtos;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateOrderDto {
  private String id;

  private String owner;

  private String address;

  private String state;
}

  