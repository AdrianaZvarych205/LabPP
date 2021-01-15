package com.company;

import java.util.ArrayList;

public class GameRoom {
    private final String GameRoomName;

    private final ArrayList<Toy> toysForGameRoom;

    public GameRoom(String GameRoomName) {
        if (GameRoomName == null || GameRoomName.equals(""))
            throw new IllegalArgumentException("Unable to create a game room with the same name!");
        this.GameRoomName = GameRoomName;
        this.toysForGameRoom = new ArrayList<>();
    }

    public void addToyToGameRoom(Toy toy) {
        if (toy == null) throw new IllegalArgumentException("Unable to add an empty toy !");
        if (!checkToyExists(toy)) toysForGameRoom.add(toy);
    }



    public String getGameRoomName() {
        return GameRoomName;
    }

    public ArrayList<Toy> getToysForGameRoom() {
        return toysForGameRoom;
    }

    private boolean checkToyExists(Toy toy) {
        for (Toy st : toysForGameRoom) {
            if (st.equals(toy)) return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        GameRoom gameroom = (GameRoom) obj;

        return GameRoomName.equalsIgnoreCase(gameroom.GameRoomName);
    }

    @Override
    public String toString() {
        return GameRoomName;
    }
}

