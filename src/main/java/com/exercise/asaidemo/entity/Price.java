package com.exercise.asaidemo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Price {
    String name;
    BigDecimal price;

    public Price() {
    }
}
