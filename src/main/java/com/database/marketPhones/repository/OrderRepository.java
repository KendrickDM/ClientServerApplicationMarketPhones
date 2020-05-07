package com.database.marketPhones.repository;

import com.database.marketPhones.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
