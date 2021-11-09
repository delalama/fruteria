package com.exercise.asaiDemo.offer;

import com.exercise.asaiDemo.entity.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EveryFourEurosOnPearsOneEuroDiscountTest {

    EveryFourEurosOnPearsOneEuroDiscount everyFourEurosOnPearsOneEuroDiscount = new EveryFourEurosOnPearsOneEuroDiscount();

    @Test
    public void everyFourEurosOnPearsOneEuroDiscount_test() {
        // given

        Product product0 = new Product();
        product0.setName("PEAR");
        product0.setPrice(10.5);
        product0.setQuantity(10);

        List<Product> products = Arrays.asList(product0);

        // when

        Double discount = everyFourEurosOnPearsOneEuroDiscount.calculate(products);

        // then

        Assertions.assertEquals(discount, 26.25);
    }
}