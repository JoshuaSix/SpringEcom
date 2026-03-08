package com.josh.SpringEcom.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity(name = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    private Long id;
    @Column(unique = true)
    private Integer OrderId;
    private String CustomerName;
    private String email;
    private String Status;
    private LocalDate OrderDate;

    @OneToMany(mappedBy = "order", cascade = cascadeType.ALL)
    private List<OrderItem> items;
}
