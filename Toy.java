package com.company;

import java.util.Objects;

public class Toy {

    private GameRoom gameroom;

    private static int toyIdCounter = 1;

    private final String toyName;

    private final int toyId;

    private final int toyWeight;

    private final int toyPrice;

    private final int toyPricec;

    public Toy(String toyName, int toyId, int toyWeight, int toyPrice, int toyPricec) {
        toyId = toyIdCounter++;
        this.toyName = toyName;
        this.toyId = toyId;
        this.toyWeight = toyWeight;
        this.toyPrice = toyPrice;
        this.toyPricec = toyPricec;

    }

    public String getToyName() {
        return toyName;
    }

    public int getToyId() {
        return toyId;
    }

    public int getToyWeight() {
        return toyWeight;
    }

    public int getToyPrice() {
        return toyPrice;
    }

    public int getToyPricec() {
        return toyPricec;
    }

    public void RemoveToyFromGameRoom() {
        gameroom = null;
    }

    @Override
    public String toString() {
        return "Toy{" +
                "toyName = " + toyName +
                ", toyId = " + toyId +
                ", toyWeight = " + toyWeight + " Size" +
                ", toyPrice = " + toyPrice + " ₴" +
                ", toyPricec = " + toyPricec +
                "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Toy toy = (Toy) obj;
        if (toyId != toy.toyId) return false;
        if (toyWeight != toy.toyWeight) return false;
        if (!toyName.equals(toy.toyName)) return false;
        return Objects.equals(gameroom, toy.gameroom);
    }
}
