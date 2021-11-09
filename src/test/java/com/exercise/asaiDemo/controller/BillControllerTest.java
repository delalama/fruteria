package com.exercise.asaiDemo.controller;

import com.exercise.asaiDemo.entity.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class BillControllerTest {

    @Autowired
    BillController billController ;

    @Test
    public void BillController_test() {
        // given

        Product product0 = new Product();
        product0.setName("ORANGE");
        product0.setQuantity(11);
        product0.setPrice(10.0);

        List<Product> products = List.of(product0);

        // when

        Double total = billController.createBill(products);

        // then

        Assertions.assertEquals(total, 110);
    }
}