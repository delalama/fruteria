package com.exercise.asaidemo.offer;

import com.exercise.asaidemo.entity.Fruit;
import com.exercise.asaidemo.entity.Product;
import com.exercise.asaidemo.offer.fruit.OneEuroIfThreeDifferentProducts;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

class OneEuroIfThreeDifferentProductsTest {

    final OneEuroIfThreeDifferentProducts oneEuroIfThreeDifferentProducts = new OneEuroIfThreeDifferentProducts();

    @Test
    public void oneEuroIfThreeDifferentProducts_test() {
        // given

        Fruit product0 = new Fruit();
        product0.setName("ORANGE");
        product0.setPrice(BigDecimal.valueOf(10.5));
        product0.setQuantity(10);

        Fruit product1 = new Fruit();
        product1.setName("APPLE");
        product1.setPrice(BigDecimal.valueOf(10.5));
        product1.setQuantity(10);

        Fruit product2 = new Fruit();
        product2.setName("PEAR");
        product2.setPrice(BigDecimal.valueOf(10.5));
        product2.setQuantity(10);

        List<Product> products = Arrays.asList(product0, product1, product2);

        // when

        BigDecimal discount = oneEuroIfThreeDifferentProducts.calculate(products);

        // then

        Assertions.assertTrue(discount.equals(BigDecimal.ONE));
    }

}