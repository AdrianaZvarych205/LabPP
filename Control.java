package com.company;

import java.util.ArrayList;

public class Control {
    private final ArrayList<GameRoom> gameroom;

    public ArrayList<GameRoom> getGameRoom() {
        return gameroom;
    }

    public Control() {
        gameroom = new ArrayList<>();
    }
}