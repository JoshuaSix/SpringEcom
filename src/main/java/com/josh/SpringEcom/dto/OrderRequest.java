package com.josh.SpringEcom.dto;

import org.hibernate.mapping.List;

public record OrderRequest(
        String customerName,
        String email,
        List<OrderItemRequest> items
) {
}
