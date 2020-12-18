package com.Droids;

import com.Weapons.Machinegun;
import com.Weapons.MiniBlaster;
import com.Weapons.Weapon;
import static com.Functions.Funcs.printDmgMsg;

public class Soldier extends Droid {

    Weapon weapon;

    public Soldier(){
        super();
        this.weapon = new MiniBlaster();
    }

    public Soldier(String name, double health, int minDamage, int maxDamage, int armour, Weapon weapon){
        super(name, health, minDamage, maxDamage, armour);
        this.weapon = weapon;
    }

    public Soldier(Soldier obj){
        super(obj);
        this.weapon = obj.weapon;
    }

    @Override
    public void attack(Droid target) {
        if(!this.isAlive()) return;

        if (this.weapon.getName().equals("None")){
            super.attack(target);
            return;
        }

        double damage = weapon.shoot(target);
        if (printDmgMsg == 1) weapon.shootMsg();
        printDmgMsg(this.name, this.health, target, damage, printDmgMsg);
        target.health = target.health-damage;

    }

    @Override
    public String toString() {
        return super.toString() + ", Зброя: '" + this.weapon.getName() + "'";

    }

    public static SoldierBuilder newBuilder(){
        return new Soldier().new SoldierBuilder();
    }

    public class SoldierBuilder extends Builder{
        public Builder setWeapon(Weapon weapon){
            Soldier.this.weapon = weapon;
            return this;
        }
    }

}
