package com.Droids;

import java.util.Formatter;

import static com.Functions.Funcs.printDmgMsg;

public class Droid {

    protected String name;
    protected double health;
    protected int minDamage;
    protected int maxDamage;
    protected int armour;
    public static int printDmgMsg = 0;
    private double preFighthealth;

    public Droid(){
        name = "Noname";
        health = 100;
        preFighthealth = health;
        minDamage = 4;
        maxDamage = 10;
        armour = 1;
    }

    public Droid(String name, double health, int minDamage, int maxDamage, int armour){
        this.name = name;
        this.health = health;
        this.preFighthealth = health;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.armour = armour;
    }

    public Droid(Droid obj){
        this.health = obj.health;
        this.preFighthealth = obj.preFighthealth;
        this.name = obj.name;
        this.minDamage = obj.minDamage;
        this.maxDamage = obj.maxDamage;
        this.armour = obj.armour;
    }

    @Override
    public String toString() {
        return "Дроїд '" +
                 name + '\'' +
                ", Здоров'я=" + health +
                ", мін.урон=" + minDamage +
                ", макс.урон=" + maxDamage +
                ", Броня=" + armour;
    }

    public void setArmour(int armour) {
        this.armour = armour;
    }

    public void setMaxDamage(int maxDamage) {
        this.maxDamage = maxDamage;
    }

    public void setMinDamage(int minDamage) {
        this.minDamage = minDamage;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public int getArmour() {
        return armour;
    }

    public int getMaxDamage() {
        return maxDamage;
    }

    public int getMinDamage() {
        return minDamage;
    }

    public double getHealth() {
        return health;
    }

    public String getName() {
        return name;
    }

    public void setPrintDmgMsg(int value) {this.printDmgMsg = value;}

    public void setPreFighthealth(double health){
        this.preFighthealth = health;
    }

    public double getPreFighthealth() {
        return preFighthealth;
    }

    public void attack(Droid target){
        if(!this.isAlive()) return;
        double damage = (int)((Math.random()*(maxDamage-minDamage))+minDamage);
        damage = (damage * (1-(0.5* target.armour)/(0.9+Math.abs(target.armour))));
        Droid attacker = new Droid(name, health, minDamage, maxDamage, armour);
        printDmgMsg(getName(), getHealth(), target, damage, printDmgMsg);
        target.health -= damage;

    }

    public boolean isAlive(){
        if(health > 0) return true;
        else return false;
    }

    public static Builder newBuilder() {
        return new Droid().new Builder();
    }

    public class Builder{
        protected Builder(){

        }

        public Builder setName(String name){
            Droid.this.name = name;
            return this;
        }

        public Builder setHealth(double health){
            Droid.this.health = health;
            Droid.this.preFighthealth = health;
            return this;
        }

        public Builder setMinDamage(int minDamage){
            Droid.this.minDamage = minDamage;
            return this;
        }

        public Builder setMaxDamage(int maxDamage){
            Droid.this.maxDamage = maxDamage;
            return this;
        }

        public Builder setArmour(int armour){
            Droid.this.armour = armour;
            return this;
        }

        public Droid build(){
            return Droid.this;
        }
    }

}

