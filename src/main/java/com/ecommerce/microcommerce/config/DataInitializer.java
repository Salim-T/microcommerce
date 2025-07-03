package com.ecommerce.microcommerce.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.ecommerce.microcommerce.dao.OrderDao;

@Component
@Profile("!test") 
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private OrderDao orderDao;

    @Override
    public void run(String... args) throws Exception {
        // Les données d'exemple sont déjà initialisées dans OrderDaoImpl
        System.out.println("Order microservice initialized successfully!");
        System.out.println("Available orders: " + orderDao.findAll().size());
    }
}
