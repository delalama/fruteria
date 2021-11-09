package com.exercise.asaiDemo.controller;

import com.exercise.asaiDemo.entity.Product;
import com.exercise.asaiDemo.repository.ProductRepository;
import com.exercise.asaiDemo.service.BillService;
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
        product0.setPrice(Double.valueOf(10));

        List<Product> products = Arrays.asList(product0);

        // when

        Double total = billController.createBill(products);

        // then

        Assertions.assertEquals(total, 110);
    }
}