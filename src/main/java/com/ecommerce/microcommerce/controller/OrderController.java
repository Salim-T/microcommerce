package com.ecommerce.microcommerce.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ecommerce.microcommerce.dao.OrderDao;
import com.ecommerce.microcommerce.model.Order;
import java.util.List;

@RestController
public class OrderController {

    private final OrderDao orderDao;

    public OrderController(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @GetMapping("/orders")
    public List<Order> listOrders() {
        return orderDao.findAll();
    }

    @GetMapping("/orders/{id}")
    public Order getOrderById(@PathVariable int id) {
        return orderDao.findById(id);
    }
}
