package com.suarezr.orders_msvc.common.exceptions;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorMessageShort extends ErrorMessage {
    String message;
    String error;
    int statusCode;
}

  