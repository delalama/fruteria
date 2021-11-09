package com.exercise.asaiDemo.entity;

import lombok.Builder;
import lombok.Value;

import java.util.List;

// Tanto el Builder como el value de lombok los veo ideales para evitar errores en dev,
// las propiedades las convierte final.
@Value
@Builder
public class Bill {

    List<Product> products;

    public Double getTotalPrice() {

        return products.stream()
                .map(p -> p.getPrice() * p.getQuantity())
                .reduce(0D, Double::sum);
    }

}
