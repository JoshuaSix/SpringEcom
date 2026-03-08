package com.josh.SpringEcom.controller;

import com.josh.SpringEcom.dto.OrderRequest;
import com.josh.SpringEcom.dto.OrderResponse;
import com.josh.SpringEcom.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin( origins = "http://localhost:5173")
@RequestMapping("/api")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/place/order")
    public ResponseEntity<OrderResponse> placeOrder(@RequestBoby OrderRequest orderRequest){
        OrderResponse orderResponse = orderService.placeOrderResponse(orderRequest);
        return new ResponseEntity<>(orderResponse,
                HttpStatus.CREATED);
    }

}
