package com.exercise.asaiDemo.offer;

import com.exercise.asaiDemo.entity.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class BuyThreeApplesAndPayTwoTest {

    final BuyThreeApplesAndPayTwo buyThreeApplesAndPayTwo = new BuyThreeApplesAndPayTwo();

    @Test
    public void buyThreeApplesAndPayTwo_test() {
        // given

        Product product0 = new Product();
        product0.setName("APPLE");
        product0.setPrice(10.5);
        product0.setQuantity(10);

        List<Product> products = List.of(product0);

        // when

        Double discount = buyThreeApplesAndPayTwo.calculate(products);

        // then

        Assertions.assertEquals(discount, 31.5);
    }
}