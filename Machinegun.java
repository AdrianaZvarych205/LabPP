package com.Weapons;

public class Machinegun extends Weapon{

    public Machinegun(){
        name = "Кулемет";
        damage = 18;
        piercing = 3;
    }

    @Override
    public void shootMsg(){
        System.out.println("Ratatata!");
    }
}
