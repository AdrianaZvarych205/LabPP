package com.Arena;
import com.Droids.Droid;
import com.Droids.Engineer;

import static com.Functions.Funcs.*;

import java.util.ArrayList;

public class BattleArena {

    public void startBattle(Droid fighter1, Droid fighter2){
        System.out.println("\n\n");
        Droid winner = soloFight(fighter1, fighter2);
        System.out.printf("Переможець '%s' з %.2f hp\n", winner.getName(), winner.getHealth());
    }

    public void startBattle(ArrayList<Droid> team1, ArrayList<Droid> team2){

        int winner = teamFight(team1, team2);
        System.out.println("\n\tПеремогла команда №" + winner + "\n");
        ArrayList<Droid> winnerTeam;
        if(winner == 1){
            winnerTeam = team1;
        }else{
            winnerTeam = team2;
        }
        for (int i = 0; i < winnerTeam.size(); i++) {
            System.out.println("\t| " + winnerTeam.get(i).toString());
        }
    }

    public static boolean bothAlive(Droid fighter1, Droid fighter2){
        if(fighter1.isAlive() && fighter2.isAlive()) return true;
        else return false;
    }

    public static boolean bothAlive(ArrayList<Droid> team1, ArrayList<Droid> team2){
        int tsize1 = getTeamSize(team1);
        int tsize2 = getTeamSize(team2);

        if((tsize1!=0) && (tsize2!=0)) return true;
        else return false;
    }

    public static int getTeamSize(ArrayList<Droid> team){
        int tsize = 0;
        for (int i = 0; i < team.size(); i++) {
            if(team.get(i).getHealth()>0){
                tsize++;
            }
        }
        return tsize;
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



}
