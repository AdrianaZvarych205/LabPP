package com.company.Commands;

import com.company.Control;
import com.company.GameRoom;
import com.company.Toy;
import com.company.ToyPriceComprasion;
import java.util.ArrayList;

public class SortToysByValue extends Command {
    public SortToysByValue(Control control) {
        this.control = control;
    }

    @Override
    public void execute() {
        System.out.println("\nSorted toys by value:\n");
        ArrayList<Toy> toys = getAllToys();
        toys.sort(new ToyPriceComprasion());
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



