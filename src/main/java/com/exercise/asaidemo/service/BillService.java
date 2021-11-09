package com.exercise.asaidemo.service;

import com.exercise.asaidemo.entity.Bill;
import com.exercise.asaidemo.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * Service to isolate bill operations.
 * OfferService has been extracted in order to only have one place to
 * develop offers logic.
 */
@Service
@Slf4j
public class BillService {

    private final OfferService offerService;

    public BillService(OfferService offerService) {
        this.offerService = offerService;
    }

    public <T extends Product> BigDecimal createFactura(List<T> products) {
        log.info("\n** NUEVA COMPRA **" + "\n-PRODUCTOS\n" + getProductsList(products));

        BigDecimal total = Bill.builder()
                .products((List<Product>) products)
                .build()
                .getTotalPrice();

        log.info("\n** TOTAL **\n " + total);

        BigDecimal discount = BigDecimal.ZERO;

        if(offerService.ACTIVE_OFFERS) {
            discount = calculateDiscount(products);
        }
        log.info("A PAGAR : " + (total.subtract(discount)) + " €.");

        return total.subtract(discount);
    }

    private <T extends Product> BigDecimal calculateDiscount(List<T> products) {
        BigDecimal discount;

        log.info("** Descuentos **");
        discount = offerService.calculateDiscount(products);
        log.info("** TOTAL DESCUENTOS **");
        log.info(discount + " €.");
        return discount;
    }

    private <T extends Product> String getProductsList(List<T> products) {
        StringBuilder productList = new StringBuilder();

        for (Product product : products) {
            productList.append("\n	Nombre: ").append(product.getName()).append(" |	Precio: ").append(product.getPrice()).append(" |	Cantidad: ").append(product.getQuantity());
        }

        return productList.toString();
    }

}
