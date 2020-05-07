package com.database.marketPhones.service;

import com.database.marketPhones.model.Order;
import com.database.marketPhones.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order findById(Long idO){
        return orderRepository.getOne(idO);
    }

    public List<Order> findAll(){
        return orderRepository.findAll();
    }

    public Order saveOrder(Order order){
        return orderRepository.save(order);
    }

    public void deleteById(Long idO){
        orderRepository.deleteById(idO);
    }
}
