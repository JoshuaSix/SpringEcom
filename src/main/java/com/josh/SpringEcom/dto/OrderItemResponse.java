package com.josh.SpringEcom.dto;

import java.math.BigDecimal;

public record OrderItemResponse(
        String productName,
        int quantity,
        int totalPrice
) {}
