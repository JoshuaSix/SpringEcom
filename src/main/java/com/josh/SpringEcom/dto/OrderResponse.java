package com.josh.SpringEcom.dto;

public record OrderResponse(
        String orderId,
        String customerName,
        String email,
        String status,
        LocalDate orderDate,
        List<OrderItemResponse> items
) {
}
