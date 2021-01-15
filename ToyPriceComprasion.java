package com.company;

public class ToyPriceComprasion implements java.util.Comparator<Toy> {

    public int compare(Toy toy1, Toy toy2) {
        return (toy1.getToyPrice() - toy2.getToyPrice());
    }
}