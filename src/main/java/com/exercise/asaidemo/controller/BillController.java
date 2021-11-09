package com.exercise.asaidemo.controller;

import com.exercise.asaidemo.entity.Fruit;
import com.exercise.asaidemo.service.BillService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.List;

/**
 * Controller to access BillService
 */
@Controller
@RequestMapping(value = "/factura")
@AllArgsConstructor
public class BillController {

    private final BillService facturaService;

    @PostMapping(value = "/total", consumes = "application/json")
    @ResponseBody
    public BigDecimal createBill(@RequestBody List<Fruit> products) {

        return facturaService.createFactura(products);
    }

}
