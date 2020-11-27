package com.butterfly.main;

import com.butterfly.product.Product;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {


    static List<Product> byName(List<Product> products, String naming) {
        Predicate<Product> name = product -> product.getNaming().equals(naming);
        return products.stream().filter(name).collect(Collectors.toList());
    }

    static List<Product> byNameAndPrice(List<Product> products, String naming, double maxPrice) {
        Predicate<Product> nameAndPrice = product -> product.getNaming().equals(naming) && product.getPrice() <= maxPrice;
        return products.stream().filter(nameAndPrice).collect(Collectors.toList());
    }

    static List<Product> byExpirationPeriod(List<Product> products, Date minExpirationPeriod) {
        Predicate<Product> name = product -> product.getExpirationPeriod().compareTo(minExpirationPeriod) >= 0;
        return products.stream().filter(name).collect(Collectors.toList());
    }

    static void display(List<Product> products, String label) {
        System.out.println(label);
        for (var product : products) {
            System.out.println(product.toString());
        }
        System.out.println();
    }

    public static void main(String[] args) {

        List<Product> products = new ArrayList<Product>();
        products.add(new Product(1, "A", "B", 1, new Date(1, 0, 0), 1));
        products.add(new Product(2, "A", "C", 2, new Date(2, 0, 0), 1));
        products.add(new Product(3, "B", "C", 3, new Date(3, 0, 0), 1));

        display(byName(products, "A"), "by name");
        display(byNameAndPrice(products, "A", 1.5), "by name and price");
        display(byExpirationPeriod(products, new Date(1, 6, 0)), "by expiration period");
    }
}
