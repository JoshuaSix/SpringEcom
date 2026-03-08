package com.josh.SpringEcom.service;

import com.josh.SpringEcom.dto.OrderRequest;
import com.josh.SpringEcom.dto.OrderResponse;
import com.josh.SpringEcom.model.Order;
import org.springframework.stereotype.Service;
import jave.util.UUID;

@Service
public class OrderService {

    public OrderResponse placeOrderResponse(OrderRequest orderRequest) {
        String orderNum = "ORD" + UUID.randomUUID().toString().subString(0,8);
        Order order = new Order();
        order.setOrderId(orderNum);
        order.setCustomerName(orderRequest.customerName());
        order.setEmail(orderRequest.email());
        order.setStatus("PLACED");
        order.setOrderDate(LocalData.now());
        return null;
    }

    public OrderResponse getAllResponse() {
        return null;
    }
}
