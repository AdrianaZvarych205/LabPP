package com.company.Commands;

import com.company.Toy;
import com.company.GameRoom;
import com.company.Control;
import java.util.ArrayList;

public class OverallValueInPrice extends Command {

    public OverallValueInPrice(Control control) {
        this.control = control;
    }

    @Override
    public void execute() {
        int totalPrice = 0;
        ArrayList<Toy> toys = getAllToys();
        for (Toy toy : toys) {
            totalPrice = totalPrice + toy.getToyPrice();
        }
        System.out.println("\nOverall value of all toys: " + totalPrice + " ₴");
    }

    private ArrayList<Toy> getAllToys() {
        ArrayList<Toy> toys = new ArrayList<>();
        for (GameRoom gameroom : control.getGameRoom()) {
            toys.addAll(gameroom.getToysForGameRoom());
        }
        return toys;
    }
}
