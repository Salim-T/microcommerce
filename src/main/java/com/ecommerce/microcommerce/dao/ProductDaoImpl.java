package com.ecommerce.microcommerce.dao;

import com.ecommerce.microcommerce.model.Product;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class ProductDaoImpl implements ProductDao {

    public static List<Product> products = new ArrayList<>();

    static {
        // Sample data for demonstration purposes
        products.add(new Product(1, "Product A", 29.99));
        products.add(new Product(2, "Product B", 49.99));
        products.add(new Product(3, "Product C", 19.99));
    }

    // Implement the methods from ProductDao interface
    @Override
    public List<Product> findAll() {
        // Logic to retrieve all products
        return products;
    }

    @Override
    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null; // or throw an exception if not found
    }

    @Override
    public Product save(Product product) {
        products.add(product);
        return product;
    }

    @Override
    public void deleteById(int id) {
        products.removeIf(product -> product.getId() == id);
    }
}
