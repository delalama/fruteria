package com.exercise.asaidemo.service;

import com.exercise.asaidemo.entity.Price;
import com.exercise.asaidemo.entity.Product;
import com.exercise.asaidemo.exception.NoPriceFoundException;
import com.exercise.asaidemo.repository.PriceRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PriceService {

    private final PriceRepository priceRepository;

    public PriceService(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    public <T extends Product> List<T> setProductsPrice(List<T> products){
        products.forEach( product -> {
            BigDecimal productPrice = null;
            try {
                productPrice = priceRepository.getPrices()
                        .stream()
                        .filter( pricesStream -> product.getName().equals(pricesStream.getName()))
                        .map(Price::getPrice)
                        .findFirst()
                        .orElseThrow(() -> new NoPriceFoundException("Precio no encontrado: " + product.getName()));
            } catch (Exception e) {
                e.printStackTrace();
            }

            product.setPrice(productPrice);
                });

        return products;
    }

}
