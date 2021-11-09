package com.exercise.asaiDemo.offer;

import com.exercise.asaiDemo.entity.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OneEuroIfThreeDifferentProductsTest {

    OneEuroIfThreeDifferentProducts oneEuroIfThreeDifferentProducts = new OneEuroIfThreeDifferentProducts();

    @Test
    public void oneEuroIfThreeDifferentProducts_test() {
        // given

        Product product0 = new Product();
        product0.setName("ORANGE");
        product0.setPrice(10.5);
        product0.setQuantity(10);

        Product product1 = new Product();
        product1.setName("APPLE");
        product1.setPrice(10.5);
        product1.setQuantity(10);

        Product product2 = new Product();
        product2.setName("PEAR");
        product2.setPrice(10.5);
        product2.setQuantity(10);

        List<Product> products = Arrays.asList(product0, product1, product2);

        // when

        Double discount = oneEuroIfThreeDifferentProducts.calculate(products);

        // then

        Assertions.assertEquals(discount, 1.0);
    }

}