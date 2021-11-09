package com.exercise.asaiDemo.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class BillTest {

    @Test
    public void bill_test() {
        Fruit product0 = new Fruit();
        product0.setName("ORANGE");
        product0.setPrice(10.5);
        product0.setQuantity(10);

        Fruit product1 = new Fruit();
        product1.setName("APPLE");
        product1.setPrice(10.5);
        product1.setQuantity(10);

        Fruit product2 = new Fruit();
        product2.setName("PEAR");
        product2.setPrice(10.5);
        product2.setQuantity(10);

        List<Product> products = Arrays.asList(product0, product1, product2);

        Bill bill = Bill.builder()
                .products(products)
                .build();


        Double total = bill.getTotalPrice();
        Assertions.assertEquals(total, 315.0);


        List<Product> productList = bill.getProducts();
        Assertions.assertEquals(products, productList);
    }
}