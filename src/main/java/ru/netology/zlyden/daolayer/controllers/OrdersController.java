package ru.netology.zlyden.daolayer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import ru.netology.zlyden.daolayer.domain.Order;
import ru.netology.zlyden.daolayer.repositories.OrdersRepository;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersController {
    private final OrdersRepository ordersRepository;

    @Autowired
    public OrdersController(OrdersRepository ordersRepository) {
            this.ordersRepository = ordersRepository;
    }

    @GetMapping
    public List<Order> getOrders() {
        return ordersRepository.getAllOrders();
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return ordersRepository.createOrder(order);
    }
}
