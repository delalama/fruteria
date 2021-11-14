package com.exercise.asaidemo.offer.fruit;

import com.exercise.asaidemo.entity.Product;
import com.exercise.asaidemo.offer.OfferInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j(topic = "FRUIT SHOP")
public class BuyThreeAndPayTwo implements OfferInterface {

    public <T extends Product> BigDecimal calculate(final List<T> products) {
        List<String> productsToApply = h2Products();

        BigDecimal discount = BigDecimal.valueOf(0);

        for (String p : productsToApply){
            discount = discount.add(applyDiscount(p,products));
        }
        return discount;
    }

    private <T extends Product> BigDecimal applyDiscount(String productName, List<T> products) {

        Integer applesAmount = calculateAmount(productName, products);

        BigDecimal discount = BigDecimal.valueOf(0);

        if (applesAmount == 0) {
            return discount;
        }

        List<Product> apples = products.stream()
                .filter(p -> p.getName().equals(productName))
                .collect(Collectors.toList());

        discount = BigDecimal.valueOf(applesAmount / 3).multiply(apples.get(0).getPrice());

        if (discount.compareTo(BigDecimal.ZERO) == 1) {
            log.info(getDescription() + " over " + productName + "-> " + discount + " €.");
        }

        return discount;
    }

    private void apply(String p) {

    }

    private List<String> h2Products() {
        var url = "jdbc:h2:file:./db/store";
        var user = "";
        var passwd = "";

        var query = "SELECT product FROM OFFERSDESC";

        List<String> productsArray = new ArrayList<>();

        try (var con = DriverManager.getConnection(url, user, passwd);
             var st = con.createStatement();
             var rs = st.executeQuery(query)) {

            while (rs.next()) {
                var products = rs.getString("product");
                productsArray = List.of(products.split(","));
            }

        } catch (SQLException ex) {

        }
        return productsArray;
    }

    private <T extends Product> Integer calculateAmount(String productName, List<T> products) {
        return products.stream()
                .filter(p -> productName.equals(p.getName()))
                .map(Product::getQuantity)
                .reduce(0, Integer::sum);
    }

    @Override
    public String getCode() {
        return "0";
    }

    @Override
    public String getName() {
        return "Buy 3 pay 2";
    }

}
