package com.exercise.asaiDemo.offer;

import com.exercise.asaiDemo.entity.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FreeOrangePerTwoPearsTest {

    FreeOrangePerTwoPears freeOrangePerTwoPears = new FreeOrangePerTwoPears();

    @Test
    public void freeOrangePerTwoPears_test() {
        // given

        Product product0 = new Product();
        product0.setName("PEAR");
        product0.setPrice(10.5);
        product0.setQuantity(10);

        List<Product> products = Arrays.asList(product0);

        // when

        Double discount = freeOrangePerTwoPears.calculate(products);

        // then

        Assertions.assertEquals(discount, 0);

        // given
        Product product1 = new Product();
        product1.setName("ORANGE");
        product1.setPrice(10.5);
        product1.setQuantity(10);

        // when

        List<Product> products2 = Arrays.asList(product0, product1);

        Double discount2 = freeOrangePerTwoPears.calculate(products2);

        // then

        Assertions.assertEquals(discount2, 52.5);

    }
}