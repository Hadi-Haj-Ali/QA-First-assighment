package main.najah.test;

import main.najah.code.Product;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {

    Product product;

    @BeforeEach
    void setup() {
        product = new Product("Laptop", 1000);
    }

    @Test
    @DisplayName("Valid Discount")
    void testValidDiscount() {
        product.applyDiscount(20);
        assertEquals(800, product.getFinalPrice());
        assertEquals(20, product.getDiscount());
    }

    @Test
    @DisplayName("Invalid Discount")
    void testInvalidDiscount() {
        assertThrows(IllegalArgumentException.class,
                () -> product.applyDiscount(60));
    }

    @Test
    @DisplayName("Negative Price")
    void testInvalidPrice() {
        assertThrows(IllegalArgumentException.class,
                () -> new Product("Phone", -5));
    }
    
    @Test
    @DisplayName("Zero discount")
    void testZeroDiscount() {
        product.applyDiscount(0);
        assertEquals(1000, product.getFinalPrice());
    }

    @Test
    @DisplayName("Max valid discount")
    void testMaxDiscount() {
        product.applyDiscount(50);
        assertEquals(500, product.getFinalPrice());
    }

    @Test
    @DisplayName("Getters test")
    void testGetters() {
        assertEquals("Laptop", product.getName());
        assertEquals(1000, product.getPrice());
    }
}