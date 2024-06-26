package com.suarezr.orders_msvc.common.exceptions;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorMessageSimple extends ErrorMessage {
    String message;
    int statusCode;
}
  