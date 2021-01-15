package com.company.Commands;

import com.company.Control;
import com.company.GameRoom;
import com.company.Toy;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Logger;

public class PricecRange extends Command {
    private final Logger LOGGER = Logger.getLogger(PricecRange.class.getName());

    public PricecRange(Control control) {
        this.control = control;
    }

    @Override
    public void execute() {
        ArrayList<Toy> toys = getAllToys();


        int lowerBoundary = inputLower();
        if (lowerBoundary < 1) {
            LOGGER.warning("Lower boundary has to be a positive value...");
            return;
        }
        int upperBoundary = inputUpper();
        if (lowerBoundary >= upperBoundary) {
            LOGGER.warning("Lower boundary has to be smaller than upper boundary");
            return;
        }

        for (Toy toy : toys) {
            if (toy.getToyPrice() > lowerBoundary && toy.getToyPrice() < upperBoundary) {
                System.out.println("\nToys in given price range:\n");
                getAllToys();
                System.out.println(toy);
            } else {
                System.out.println("\nUnable to find toys in this price range...");
            }
        }
    }

    private ArrayList<Toy> getAllToys() {
        ArrayList<Toy> toys = new ArrayList<>();
        for (GameRoom gameroom : control.getGameRoom()) {
            toys.addAll(gameroom.getToysForGameRoom());
        }
        return toys;
    }

    private static int inputLower() {
        Scanner scan = new Scanner(System.in);
        System.out.println("\n Please enter the lower price boundary:");
        return scan.nextInt();
    }

    private static int inputUpper() {
        Scanner scan = new Scanner(System.in);
        System.out.println("\n Please enter the upper price boundary:");
        return scan.nextInt();
    }
}
