package com.exercise.asaidemo.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;


@Getter
@Setter
@Component
public abstract class Product {

    String name;
    BigDecimal price;
    Integer quantity;
}
