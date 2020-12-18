package com.Droids;

import com.Weapons.Weapon;

public class Engineer extends Droid {

    private double health_regen;

    public Engineer(){
        health_regen = 12;
    }

    public static Engineer.EngineerBuilder newBuilder(){
        return new Engineer().new EngineerBuilder();
    }

    public class EngineerBuilder extends Builder{
        public Builder setRegen(double regen){
            Engineer.this.health_regen = regen;
            return this;
        }
    }

    public String toString() {
        return super.toString() + ", Регенерація: '" + this.health_regen + "'";

    }

    public void heal(Droid target){
        if(printDmgMsg==1){
            System.out.println("'" + this.name + "' вилікував '" + target.name + "' на " + health_regen + " hp");
        }
        target.setHealth(target.getHealth()+health_regen);
    }
}
