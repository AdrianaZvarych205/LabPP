package com.company;

public class ToyWightComprasion implements java.util.Comparator<Toy> {

    public int compare(Toy toy1, Toy toy2) {
        return (toy1.getToyWeight() - toy2.getToyWeight());
    }
}
