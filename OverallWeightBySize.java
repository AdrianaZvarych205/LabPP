package com.company.Commands;

import com.company.Toy;
import com.company.GameRoom;
import com.company.Control;
import java.util.ArrayList;

public class OverallWeightBySize extends Command {
    public OverallWeightBySize(Control control) {
        this.control = control;
    }

    @Override
    public void execute() {
        int totalWeight = 0;
        ArrayList<Toy> toys = getAllToys();
        for (Toy toy : toys) {
            totalWeight = totalWeight + toy.getToyWeight();
        }
        System.out.println("\nOverall weight of all toys: " + totalWeight + " Size");
    }

    private ArrayList<Toy> getAllToys() {
        ArrayList<Toy> toys = new ArrayList<>();
        for (GameRoom gameroom : control.getGameRoom()) {
            toys.addAll(gameroom.getToysForGameRoom());
        }
        return toys;
    }
}
