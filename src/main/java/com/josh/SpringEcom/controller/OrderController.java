package com.josh.SpringEcom.controller;

import com.josh.SpringEcom.dto.OrderItemResponse;
import com.josh.SpringEcom.dto.OrderRequest;
import com.josh.SpringEcom.dto.OrderResponse;
import com.josh.SpringEcom.service.OrderService;
import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/place")
    public ResponseEntity<List<OrderItemResponse>> getAllOrder(){
        List<OrderItemResponse> responses  = orderService.getAllResponse();
        return new ResponseEntity<>(responses,
                HttpStatus.OK);
    }

}
