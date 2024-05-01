package com.suarezr.orders_msvc.common.nats;

public record NatsResponseDto(boolean success, int statusCode, String errorMessage, String payload) {
}
