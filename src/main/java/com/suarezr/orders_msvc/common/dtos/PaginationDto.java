package com.suarezr.orders_msvc.common.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaginationDto {
  private Integer page;
  private Integer limit;
  private String sortBy;
}
