package com.exercise.asaiDemo.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Product {

    String name;
    Double price;
    Integer quantity;
}
