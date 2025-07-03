package com.ecommerce.microcommerce.dao;

import com.ecommerce.microcommerce.model.Order;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderDaoImpl implements OrderDao {
    private static final List<Order> orders = new ArrayList<>();

    static {
        orders.add(new Order(1, "First order", 100.0));
        orders.add(new Order(2, "Second order", 250.5));
        orders.add(new Order(3, "Third order", 75.25));
    }

    @Override
    public List<Order> findAll() {
        return new ArrayList<>(orders);
    }

    @Override
    public Order findById(int id) {
        return orders.stream().filter(o -> o.getId() == id).findFirst().orElse(null);
    }
}
