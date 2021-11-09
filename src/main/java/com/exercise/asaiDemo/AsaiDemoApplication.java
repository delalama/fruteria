package com.exercise.asaiDemo;

import com.exercise.asaiDemo.repository.PurchaseRepository;
import com.exercise.asaiDemo.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class AsaiDemoApplication implements CommandLineRunner {

    @Autowired
    PurchaseRepository appProducts;

    @Value("${business.name")
    String businessName;

    @Autowired
    BillService billService;

    public static void main(String[] args) {
        SpringApplication.run(AsaiDemoApplication.class, args);
    }

    @Override
    public void run(String... args) {
        printEnvironmentConfig();

        billService.createFactura(appProducts.getFruits());
    }

    private void printEnvironmentConfig() {
        String applicationName = "\nAPLICACIÓN GESTIÓN " + businessName;
        String webInfo = "\n WEB: http://localhost:8080/shop";

        System.out.println(applicationName + webInfo);
    }

}
