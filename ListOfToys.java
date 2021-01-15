package com.company.Commands;

import com.company.Control;
import com.company.Toy;
import com.company.GameRoom;
import java.util.ArrayList;

public class ListOfToys extends Command {
    public ListOfToys(Control control) {
        this.control = control;
    }

    @Override
    public void execute() {
        System.out.println("\nList of all toys:");
        for (Toy toy : getAllToys()) System.out.println(toy);
    }

    private ArrayList<Toy> getAllToys() {
        ArrayList<Toy> toys = new ArrayList<>();
        for (GameRoom gameroom : control.getGameRoom()) {
            toys.addAll(gameroom.getToysForGameRoom());
        }
        return toys;
    }
}

