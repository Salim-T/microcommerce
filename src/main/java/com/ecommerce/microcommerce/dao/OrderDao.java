package com.ecommerce.microcommerce.dao;

import com.ecommerce.microcommerce.model.Order;
import java.util.List;

public interface OrderDao {
    List<Order> findAll();
    Order findById(int id);
}
