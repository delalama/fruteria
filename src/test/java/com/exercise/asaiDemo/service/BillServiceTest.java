package com.exercise.asaiDemo.service;

import com.exercise.asaiDemo.controller.BillController;
import com.exercise.asaiDemo.entity.Product;
import com.exercise.asaiDemo.offer.BuyThreeApplesAndPayTwo;
import com.exercise.asaiDemo.offer.OfferInterface;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BillServiceTest {

    List<OfferInterface> offers = Arrays.asList(new BuyThreeApplesAndPayTwo());

    @Value("${active-offers}")
    final List<String> activeOffersCodes = Arrays.asList("0","1","2","3");

    OfferService offerService = new OfferService(offers, activeOffersCodes);

    BillService billService = new BillService(offerService) ;

    @Test
    public void BillService_test() {
        // given

        Product product0 = new Product();
        product0.setName("ORANGE");
        product0.setQuantity(11);
        product0.setPrice(Double.valueOf(10));

        List<Product> products = Arrays.asList(product0);

        // when

        Double total = billService.createFactura(products);

        // then

        Assertions.assertEquals(total, 110);
    }
}