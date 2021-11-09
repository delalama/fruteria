package com.exercise.asaiDemo.offer;

import com.exercise.asaiDemo.entity.Product;

import java.util.List;

public interface OfferInterface {

    Double calculate(List<Product> items);
    String getCode();
    String getName();

    default String getDescription() {
        return getCode() + " - " + getName();
    }
}
