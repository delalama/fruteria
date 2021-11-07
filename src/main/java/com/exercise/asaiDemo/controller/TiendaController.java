package com.exercise.asaiDemo.controller;

import com.exercise.asaiDemo.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TiendaController {

    @Autowired
    FacturaService facturaService;

    @Autowired
    Environment env;

    @RequestMapping("/tienda")
    public String tienda(final Model modelo) {
        modelo.addAttribute("nombre", env.getProperty("business.name"));

        return "tienda";
    }
}
