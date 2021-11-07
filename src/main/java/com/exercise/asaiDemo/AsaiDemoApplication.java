package com.exercise.asaiDemo;

import com.exercise.asaiDemo.entity.Offer;
import com.exercise.asaiDemo.repository.OfferDao;
import com.exercise.asaiDemo.repository.ProductDao;
import com.exercise.asaiDemo.entity.Product;
import com.exercise.asaiDemo.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import java.util.List;

@SpringBootApplication
public class AsaiDemoApplication implements CommandLineRunner {

	@Autowired
	private Environment env;

	@Autowired
	ProductDao appProducts;

	@Autowired
	OfferDao offerDao;

	@Autowired
	FacturaService facturaService;

	public static void main(String[] args) {
		SpringApplication.run(AsaiDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//THIS IS THE CODE TO EMULATE A STATIC BOUGHT ACROSS APPLICATION.YML
		System.out.println("APLICACIÓN GESTIÓN " + env.getProperty("business.name"));
		System.out.println("NOMBRE EMPLEADO " + env.getProperty("business.employee"));

		System.out.println("PRODUCTOS COMPRA");
		printProducts(appProducts.getProducts());

		System.out.println("OFERTAS ACTIVAS");
		printOffers(offerDao.getActive());

		System.out.println("FACTURA");
		printTotalFactura(appProducts.getProducts()) ;

		System.out.println("PUEDES ACCEDER CON TU NAVEGADOR PARA ATENDER CLIENTES");
		System.out.println("http://localhost:8080/tienda");
	}

	private void printOffers(List<Offer> offerList) {
		offerList.stream().forEach(
				o -> System.out.println(o.getName())
		);
		System.out.println();
	}

	private void printTotalFactura(List<Product> productList) {
		System.out.println("** TOTAL **" + facturaService.createFactura(productList));
	}

	private void printProducts(List<Product> productList) {
		int index = 1;
		for(Product p: productList){
			System.out.println(index + ".");
			System.out.println("	Nombre: " + p.getName());
			System.out.println("	Precio: " + p.getPrice());
			System.out.println("	Cantidad: " + p.getQuantity());
			index++;
		}
	}
}
