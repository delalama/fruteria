package com.exercise.asaiDemo;

import com.exercise.asaiDemo.repository.ProductRepository;
import com.exercise.asaiDemo.service.BillService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class AsaiDemoApplication implements CommandLineRunner {


    ProductRepository appProducts;
    private final String businessName;
    private final BillService billService;

    public AsaiDemoApplication(ProductRepository appProducts, @Value("${business.name}") String businessName, BillService billService) {
        this.appProducts = appProducts;
        this.businessName = businessName;
        this.billService = billService;
    }

    public static void main(String[] args) {
        SpringApplication.run(AsaiDemoApplication.class, args);
    }

    @Override
    public void run(String... args) {
        printEnvironmentConfig();

        billService.createFactura(appProducts.getProducts());
    }

    private void printEnvironmentConfig() {
        String applicationName = "\nAPLICACIÓN GESTIÓN " + businessName;
        String configuredOffers = "\nOFERTAS DEL DÍA CONFIGURADAS \n" + billService.offerService.printActiveOffers();
        String webInfo = "\n WEB: http://localhost:8080/shop";

        System.out.println(applicationName + configuredOffers + webInfo);
    }

}
