package com.exercise.asaiDemo.service;

import com.exercise.asaiDemo.entity.Bill;
import com.exercise.asaiDemo.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service to isolate bill operations.
 * OfferService has been extracted in order to only have one place to
 * develop offers logic.
 */
@Service
public class BillService {

    private final OfferService offerService;

    public BillService(OfferService offerService) {
        this.offerService = offerService;
    }

    public <T extends Product> Double  createFactura( List<T> products) {
        System.out.println("\n** NUEVA COMPRA **" + "\n-PRODUCTOS\n" + getProductsList(products));

        Double total = Bill.builder()
                .products((List<Product>) products)
                .build()
                .getTotalPrice();

        System.out.println("\n** TOTAL **\n " + total);

        Double discount = 0D;

        if(offerService.ACTIVE_OFFERS) {
            discount = calculateDiscount(products);
        }
        System.out.println("A PAGAR : " + (total - discount) + " €.");

        return total - discount;
    }

    private <T extends Product> Double calculateDiscount(List<T> products) {
        Double discount;

        System.out.println("** Descuentos **");
        discount = offerService.calculateDiscount(products);
        System.out.println("** TOTAL DESCUENTOS **");
        System.out.println(discount + " €.");
        return discount;
    }

    private <T extends Product> String getProductsList(List<T> products) {
        String productList = "";

        for (Product product : products) {
            productList += "\n	Nombre: " + product.getName() +
                    " |	Precio: " + product.getPrice() +
                    " |	Cantidad: " + product.getQuantity();
        }

        return productList;
    }

}
