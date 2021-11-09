package com.exercise.asaiDemo.service;

import com.exercise.asaiDemo.entity.Product;
import com.exercise.asaiDemo.offer.BuyThreeApplesAndPayTwo;
import com.exercise.asaiDemo.offer.OfferInterface;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OfferServiceTest {

    List<OfferInterface> offers = Arrays.asList(new BuyThreeApplesAndPayTwo());

    final List<String> activeOffersCodes = Arrays.asList("0","1","2","3");

    OfferService offerService = new OfferService(offers, activeOffersCodes);

    @Test
    public void offerService_test () {
        // given

        // then

        Assertions.assertEquals(offerService.ACTIVE_OFFERS,true);

        // when

        String offers = offerService.printActiveOffers();

        // then

        Assertions.assertEquals("0 - Buy 3 Apples and pay 2",offers);

        // when

        Product product0 = new Product();
        product0.setName("APPLE");
        product0.setPrice(10.5);
        product0.setQuantity(10);


        List<Product> products = Arrays.asList(product0);

        Double discount = offerService.calculateDiscount(products);

        // then

        Assertions.assertEquals(discount, 31.5);

    }
}