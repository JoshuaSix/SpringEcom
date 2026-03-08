package com.josh.SpringEcom.dto;

public record OrderItemRequest(
        int productId,
        int quantity) {
}
