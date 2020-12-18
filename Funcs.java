package com.Functions;

import java.util.ArrayList;
import java.util.Random;

import com.Droids.*;
import static com.Arena.BattleArena.bothAlive;
import static com.Arena.BattleArena.getTeamSize;

public class Funcs {

    public static int teamFight(ArrayList<Droid> team1, ArrayList<Droid> team2){

        while(bothAlive(team1, team2)) {

            setFighters(team1, team2);
            setFighters(team2, team1);
        }

        if(getTeamSize(team1)>0) return 1;
        else return 2;
    }

    public static Droid soloFight(Droid fighter1, Droid fighter2){
        while(bothAlive(fighter1, fighter2)){
            fighter1.attack(fighter2);
            fighter2.attack(fighter1);
        }
        if (fighter1.isAlive()) return fighter1;
        else return fighter2;
    }

    public static Droid getRandomDroid(ArrayList<Droid> team){
        int b = team.size();
        Random rand = new Random();
        int randInd = rand.nextInt(b);
        return team.get(randInd);
    }

    public static void setFighters(ArrayList<Droid> attackers, ArrayList<Droid> defenders){
        for (Droid droid : attackers){
                if(droid.isAlive()){
                    Droid randDroid = getRandomDroid(defenders);
                    if(randDroid.isAlive()){
                        if(droid instanceof Engineer) {
                            Droid randAttacker = getRandomDroid(attackers);
                            ((Engineer) droid).heal(randAttacker);
                        }
                        droid.attack(randDroid);
                    }

                }
        }

    }

    public static void printDmgMsg(String aname, double ahealth, Droid target, double damage, int toPrint){
        if(toPrint==1){
            System.out.printf("%s(%.2f) set %s(%.2f)    %.2f dmg.\n", aname, ahealth, target.getName(), target.getHealth(), damage);
            for (int i = 0; i < 40; i++) {
                System.out.print("-");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("");
        }
        return;
    }


}
