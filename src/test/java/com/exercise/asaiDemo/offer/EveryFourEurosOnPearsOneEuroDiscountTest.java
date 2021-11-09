package com.exercise.asaiDemo.offer;

import com.exercise.asaiDemo.entity.Fruit;
import com.exercise.asaiDemo.entity.Product;
import com.exercise.asaiDemo.offer.fruit.EveryFourEurosOnPearsOneEuroDiscount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class EveryFourEurosOnPearsOneEuroDiscountTest {

    final EveryFourEurosOnPearsOneEuroDiscount everyFourEurosOnPearsOneEuroDiscount = new EveryFourEurosOnPearsOneEuroDiscount();

    @Test
    public void everyFourEurosOnPearsOneEuroDiscount_test() {
        // given

        Fruit product0 = new Fruit();
        product0.setName("PEAR");
        product0.setPrice(10.5);
        product0.setQuantity(10);

        List<Product> products = List.of(product0);

        // when

        Double discount = everyFourEurosOnPearsOneEuroDiscount.calculate(products);

        // then

        Assertions.assertEquals(discount, 26.25);
    }
}