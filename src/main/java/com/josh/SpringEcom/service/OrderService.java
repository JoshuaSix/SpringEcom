package com.josh.SpringEcom.service;

import com.josh.SpringEcom.dto.OrderItemRequest;
import com.josh.SpringEcom.dto.OrderItemResponse;
import com.josh.SpringEcom.dto.OrderRequest;
import com.josh.SpringEcom.dto.OrderResponse;
import com.josh.SpringEcom.model.Order;
import com.josh.SpringEcom.model.OrderItem;
import com.josh.SpringEcom.model.Product;
import com.josh.SpringEcom.repository.OrderRepository;
import com.josh.SpringEcom.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

import java.time.LocalDate;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    private ProductRepository productRepository;

    public OrderResponse placeOrderResponse(OrderRequest orderRequest) {
        String orderNum = "ORD" + UUID.randomUUID().toString().substring(0,8).toUpperCase();
        Order order = new Order();
        order.setOrderId(orderNum);
        order.setCustomerName(orderRequest.customerName());
        order.setEmail(orderRequest.email());
        order.setStatus("PLACED");
        order.setOrderDate(LocalDate.now());

        List<OrderItem> orderItems = new ArrayList<>();
        for(OrderItemRequest itemRequest : orderRequest.items()){

            Product product = productRepository.findById(itemRequest.productId())
                    .orElseThrow(() -> new RuntimeException("Product Not Found"));
            product.setStockQuantity(product.getProductStock() - itemRequest.quantity());
            productRepository.save(product);

            OrderItem orderItem = OrderItem.builder()
                    .product(product)
                    .quantity(itemRequest.quantity())
                    .totalPrice(product.getProductStock() * itemRequest.quantity())
                    .order(order)
                    .build();
            orderItems.add(orderItem);
        }

        order.setItems(orderItems);
        Order saveOrder = orderRepository.save(order);

        List<OrderItemResponse> orderItemResponses = new ArrayList<>();
        for(OrderItem item : orderItems){
            OrderItemResponse orderItemResponse = new OrderItemResponse(
                    item.getProduct().getProductName(),
                    item.getQuantity(),
                    item.getTotalPrice()
            );
            orderItemResponses.add(orderItemResponse);
        }

        OrderResponse orderResponse = new OrderResponse(
                saveOrder.getOrderId(),
                saveOrder.getCustomerName(),
                saveOrder.getEmail(),
                saveOrder.getStatus(),
                saveOrder.getOrderDate(),
                orderItemResponses
        );

        return orderResponse;
    }

    public List<OrderResponse> getAllResponse() {
        return null;
    }
}
