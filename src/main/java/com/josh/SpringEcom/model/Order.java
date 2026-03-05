package com.josh.SpringEcom.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    private Long id;
    private Integer OrderId;
    private String CustomerName;
    private String orderEmail;
    private String Status;
    private LocalDate OrderDate;
    private List<OrderItem> items;
}
