package com.exercise.asaidemo.offer;

import com.exercise.asaidemo.entity.Product;

import java.math.BigDecimal;
import java.util.List;

public interface OfferInterface {

    <T extends Product> BigDecimal calculate(List<T> items);
    String getCode();
    String getName();

    default String getDescription() {
        return getCode() + " - " + getName();
    }
}
