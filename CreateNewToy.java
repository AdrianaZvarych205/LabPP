package com.company.Commands;

import com.company.Control;
import com.company.Toy;
import com.company.GameRoom;
import java.util.logging.Logger;
import java.util.Scanner;

public class CreateNewToy extends Command {
    private final Logger LOGGER = Logger.getLogger(CreateNewToy.class.getName());

    public CreateNewToy(Control control) {
        this.control = control;
    }

    @Override
    public void execute() {

        String toyName = inputString("Please enter a toy name:");
        if (toyName == null || toyName.equals("")) {
            LOGGER.warning("Game room name could not be an empty row !");
            return;
        }
        int toyId = inputId();
        if (toyId <= 0) {
            LOGGER.warning("Toy ID has to be in range of 1 to 50!");
            return;
        }
        int toyWeight = inputWeight();
        if (toyWeight <= 0) {
            LOGGER.warning("Weight of the toy has to be a positive value !");
            return;
        }
        int toyPrice = inputPrice();
        if (toyPrice <= 0) {
            LOGGER.warning("Price has to be a positive value !");
            return;
        }
        int toyPricec = inputPricec();
        if (toyPricec > 1000) {
            LOGGER.warning("Overrun the maximum price range !");
            return;
        }
        String gameroomName = inputString("Enter to which game room this toy belongs: ");
        GameRoom tempGameRoom = findGameRoom(gameroomName);
        if (tempGameRoom == null) {
            LOGGER.warning("\nUnable to find this Game room...");
            return;
        }
        Toy tempStone = new Toy(toyName, toyId, toyWeight, toyPrice, toyPricec);
        tempGameRoom.addToyToGameRoom(tempStone);
        System.out.println("\nToy has been successfully created! ");
    }

    private GameRoom findGameRoom(String gameroomName) {
        for (GameRoom elem : control.getGameRoom()) {
            if (elem.getGameRoomName().equalsIgnoreCase(gameroomName)) return elem;
        }
        return null;
    }

    private static int inputId() {
        Scanner scan = new Scanner(System.in);
        System.out.println("\nPlease enter toy Id:");
        return scan.nextInt();
    }

    private static int inputWeight() {
        Scanner scan = new Scanner(System.in);
        System.out.println("\nPlease enter toy  by size:");
        return scan.nextInt();
    }

    private static int inputPrice() {
        Scanner scan = new Scanner(System.in);
        System.out.println("\nPlease enter toy price(₴):");
        return scan.nextInt();
    }

    private static int inputPricec() {
        Scanner scan = new Scanner(System.in);
        System.out.println("\nPlease enter toy price range:");
        return scan.nextInt();
    }

    private static String inputString(String str) {
        Scanner scan = new Scanner(System.in);
        System.out.println("\n" + str);
        return scan.nextLine();
    }
}

