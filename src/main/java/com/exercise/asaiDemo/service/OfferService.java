package com.exercise.asaiDemo.service;

import com.exercise.asaiDemo.entity.Offer;
import com.exercise.asaiDemo.entity.Product;
import com.exercise.asaiDemo.repository.OfferDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service to implement Offers logic.
 */
@Service
public class OfferService {
    @Autowired
    OfferDao offerDao;

    public Double applyActiveOffers(List<Product> products, Double total) {
        List<Offer> offerList = offerDao.getActive();

        for (Offer o : offerList) {
            if (o.getName().equals("-Buy 3 Apples and pay 2")) {
                total = applyApplesDiscount(products, total);
            }

            if (o.getName().equals("-Get a free Orange for every 2 Pears you buy")) {
                applyFreeOrangePerTwoPearsDiscount(products, total);
            }
            if (o.getName().equals("-For every 4 € spent on Pears, we will deduct one euro from your final invoice")) {
                total = applyEveryFourPearsEuroDiscount(products, total);
            }
        }

        return total;
    }

    private Double applyEveryFourPearsEuroDiscount(List<Product> products, Double total) {
        List<Product> pears = products.stream()
                .filter(p -> p.getName().equals("PEAR"))
                .collect(Collectors.toList());

        Integer pearsAmount = pears.stream()
                .map(p -> p.getQuantity())
                .reduce(0, Integer::sum);

        if (pearsAmount > 3) {
            Integer eurosToDeduct = pearsAmount / 4;
            System.out.println("aplicamos descuento por cantidad peras " + eurosToDeduct);
            return total - eurosToDeduct;
        }

        return total;
    }

    private void applyFreeOrangePerTwoPearsDiscount(List<Product> products, Double total) {
        List<Product> pears = products.stream()
                .filter(p -> p.getName().equals("PEAR"))
                .collect(Collectors.toList());

        Integer pearsAmount = pears.stream()
                .map(p -> p.getQuantity())
                .reduce(0, Integer::sum);

        if (pearsAmount > 1) {
            Integer freeOranges = pearsAmount / 2;
            System.out.println("aplicamos regalo por peras " + freeOranges + " naranjas gratis por su compra");
        }
    }

    private Double applyApplesDiscount(List<Product> products, Double total) {
        System.out.println("aplicamos descuento en manzanas");

        List<Product> apples = products.stream()
                .filter(p -> p.getName().equals("APPLE"))
                .collect(Collectors.toList());

        Integer applesAmount = apples.stream()
                .map(p -> p.getQuantity())
                .reduce(0, Integer::sum);

        double discount = applesAmount / 3 * apples.get(0).getPrice();

        return total - discount;
    }

}
