package com.josh.SpringEcom.repository;

import com.josh.SpringEcom.model.Order;
import org.apache.el.stream.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {
    Optional<Order> findById (String orderId);
}
