package com.exercise.asaidemo.entity;

import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;
import java.util.List;

// Tanto el Builder como el value de lombok los veo ideales para evitar errores en dev,
// las propiedades las convierte final.
@Value
@Builder
public class Bill<T extends Product> {

    List<T> products;

    public BigDecimal getTotalPrice() {

        return products.stream()
                .map(p -> p.getPrice().multiply(BigDecimal.valueOf(p.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

}
