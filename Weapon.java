package com.Weapons;

import com.Droids.*;

public abstract class Weapon {
    protected double damage;
    protected int piercing;
    protected String name;

    public void setName(String name) {
        this.name = name;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public void setPiercing(int piercing) {
        this.piercing = piercing;
    }

    public double getDamage() {
        return damage;
    }

    public int getPiercing() {
        return piercing;
    }

    public String getName() {
        return name;
    }

    public Weapon(){
        name = "Mini-blaster";
        damage = 10;
        piercing = 1;
    }
    public Weapon(double damage, int piercing, String name){
        this.name = name;
        this.damage = damage;
        this.piercing = piercing;
    }

    public double shoot(Droid target){
        double dmg = damage * (1-(0.5* (target.getArmour()-piercing))/(0.9+Math.abs(target.getArmour()-piercing)));
        return dmg;
    }

    public void shootMsg(){
        System.out.println("Bang!");
    }
}
