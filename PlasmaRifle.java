package com.Weapons;

public class PlasmaRifle extends Weapon {

    public PlasmaRifle(){
        name = "������-��������";
        damage = 20;
        piercing = 6;
    }

    @Override
    public void shootMsg() {
        System.out.println("Peeeeeeeeeeeew!");
    }
}
