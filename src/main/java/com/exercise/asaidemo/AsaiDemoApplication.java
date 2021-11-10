package com.exercise.asaidemo;

import com.exercise.asaidemo.entity.Price;
import com.exercise.asaidemo.repository.PriceRepository;
import com.exercise.asaidemo.repository.PurchaseRepository;
import com.exercise.asaidemo.service.BillService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;


@SpringBootApplication
@Slf4j(topic = "FRUIT SHOP")
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

        log.info(applicationName + webInfo);
    }

}
