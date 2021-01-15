package com.company.Commands;

import com.company.Control;
import com.company.GameRoom;
import java.util.logging.Logger;
import java.util.Scanner;

public class CreateNewGameRoom extends Command {
    private final Logger LOGGER = Logger.getLogger(CreateNewGameRoom.class.getName());

    public CreateNewGameRoom(Control control) {
        this.control = control;

    }

    @Override
    public void execute() {
        Scanner scan = new Scanner(System.in);
        System.out.println("\nPlease enter a game room name: ");
        String gameroomName = scan.nextLine();
        if (gameroomName == null || gameroomName.equals("")) {
            LOGGER.warning("Unable to create a game room with the same name !");
            return;
        }
        if (findGameRoom(gameroomName) != null)
            LOGGER.warning("This game room already exists !");

        control.getGameRoom().add(new GameRoom(gameroomName));
        System.out.println("\nGame room has been successfully created!");

    }

    private GameRoom findGameRoom(String GameRoomName) {
        for (GameRoom elem : control.getGameRoom()) {
            if (elem.getGameRoomName().equalsIgnoreCase(GameRoomName)) return elem;
        }
        return null;
    }
}

