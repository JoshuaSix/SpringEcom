package com.josh.SpringEcom.controller;

import java.util.List;
import com.josh.SpringEcom.dto.OrderItemResponse;
import com.josh.SpringEcom.dto.OrderRequest;
import com.josh.SpringEcom.dto.OrderResponse;
import com.josh.SpringEcom.model.OrderItem;
import com.josh.SpringEcom.service.OrderService;
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
    public ResponseEntity<OrderResponse> placeOrder(@RequestBody OrderRequest orderRequest){
        OrderResponse orderResponse = orderService.placeOrderResponse(orderRequest);
        return new ResponseEntity<>(orderResponse,
                HttpStatus.CREATED);
    }

    @GetMapping("/orders")
    public ResponseEntity<List<OrderResponse>> getAllOrder(){
        List<OrderResponse> responses  = orderService.getAllResponse();
        return new ResponseEntity<>(responses,
                HttpStatus.OK);
    }

}
