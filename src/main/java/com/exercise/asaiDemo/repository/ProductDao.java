package com.exercise.asaiDemo.repository;


import com.exercise.asaiDemo.entity.Product;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@ConfigurationProperties(prefix = "stock", ignoreInvalidFields = true)
@Getter
@Setter
public class ProductDao {
    private List<Product> products;
}