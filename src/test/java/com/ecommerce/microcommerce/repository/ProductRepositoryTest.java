package com.ecommerce.microcommerce.repository;

import com.ecommerce.microcommerce.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void testSaveAndFindProduct() {
        // Given
        Product product = new Product("Test Product", 99.99);

        // When
        Product savedProduct = productRepository.save(product);

        // Then
        assertThat(savedProduct.getId()).isNotNull();
        assertThat(savedProduct.getName()).isEqualTo("Test Product");
        assertThat(savedProduct.getPrice()).isEqualTo(99.99);
    }

    @Test
    void testFindAll() {
        // Given
        productRepository.save(new Product("Product 1", 10.0));
        productRepository.save(new Product("Product 2", 20.0));

        // When
        List<Product> products = productRepository.findAll();

        // Then
        assertThat(products).hasSize(2);
    }

    @Test
    void testFindByNameContaining() {
        // Given
        productRepository.save(new Product("iPhone 15", 799.99));
        productRepository.save(new Product("Samsung Phone", 699.99));
        productRepository.save(new Product("iPad", 549.99));

        // When
        List<Product> iPhoneProducts = productRepository.findByNameContainingIgnoreCase("iphone");

        // Then
        assertThat(iPhoneProducts).hasSize(1);
        assertThat(iPhoneProducts.get(0).getName()).isEqualTo("iPhone 15");
    }

    @Test
    void testDeleteById() {
        // Given
        Product product = productRepository.save(new Product("To Delete", 99.99));
        Integer productId = product.getId();

        // When
        productRepository.deleteById(productId);

        // Then
        Optional<Product> deletedProduct = productRepository.findById(productId);
        assertThat(deletedProduct).isEmpty();
    }
}
