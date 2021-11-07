package com.exercise.asaiDemo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Bill {
    private List<Product> products;

    public Double getTotalPrice() {
        return products.stream()
                .map(p -> p.getPrice() * p.getQuantity())
                .reduce(0D, Double::sum);
    }

}
