package com.Weapons;

public class MiniBlaster extends Weapon {

    public MiniBlaster() {
        name = "Міні-бластер";
        damage = 12;
        piercing = 2;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

//    @Override
//    public void shoot(Droid target){
//        double dmg = damage * (1-(0.5* (target.getArmour()-piercing))/(0.9+Math.abs(target.getArmour()-piercing)));
//        double new_health = target.getHealth()-dmg;
//        target.setHealth(new_health);
//        shootMsg();
//    }

    @Override
    public void shootMsg(){
        System.out.println("Pew-pew!");
    }
}
