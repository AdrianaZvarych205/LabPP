package com.company.Commands;

import com.company.*;
import java.util.ArrayList;

public class SortToysByWeight extends Command {
    public SortToysByWeight(Control control) {
        this.control = control;
    }

    @Override
    public void execute() {
        System.out.println("\nSorted toys by weight:\n");
        ArrayList<Toy> toys = getAllToys();
        toys.sort(new ToyWightComprasion());
        for (Toy toy : toys) System.out.println(toy);

    }

    private ArrayList<Toy> getAllToys() {
        ArrayList<Toy> toys = new ArrayList<>();
        for (GameRoom gameroom : control.getGameRoom()) {
            toys.addAll(gameroom.getToysForGameRoom());
        }
        return toys;
    }
}





