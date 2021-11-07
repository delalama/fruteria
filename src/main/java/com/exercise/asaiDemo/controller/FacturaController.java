package com.exercise.asaiDemo.controller;

import com.exercise.asaiDemo.entity.Product;
import com.exercise.asaiDemo.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller()
@RequestMapping(value = "/factura")
public class FacturaController {
    @Autowired
    FacturaService facturaService;

    @Autowired
    Environment env;

    @RequestMapping(value = "/total", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public Double sendPostMessage(@RequestBody List<Product> products) {
        return facturaService.createFactura(products);
    }

}
