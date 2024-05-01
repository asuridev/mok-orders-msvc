package com.suarezr.orders_msvc.order.services.dtos;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemDto {

  String ProductId;

  Integer quantity;
}
