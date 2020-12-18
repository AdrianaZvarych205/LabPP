package com.GameProcess;

import com.Arena.BattleArena;
import com.Droids.*;
import com.Weapons.Machinegun;
import com.Weapons.MiniBlaster;
import com.Weapons.PlasmaRifle;
import com.Weapons.Weapon;
import static com.Droids.Droid.printDmgMsg;
import java.util.ArrayList;
import java.util.Scanner;

public class Controller {

    public void printCommandList(){
        System.out.println("\t������ ��������� ������");
        System.out.println("\t______________________________");
        System.out.println("\t1 - �������� �����\n\t2 - �������� ������ �����\n\t3 - ��������� �� 1 vs 1" +
                "\n\t4 - ��������� ��������� ��\n\t5 - ����� � ���");
        System.out.println("\t------------------------------\n");
    }

    void droidsTypeList(){
        System.out.println("\t1 - ����-�������\n\t2 - ������� ����\n\t3 - �������\n");
    }

    void weaponTypeList(){
        System.out.println("\n\t1 - ̳�-�������\n\t2 - �������\n\t3 - ������-��������\n");
    }

    public void startGame(){
        ArrayList<Droid> droidsList= new ArrayList<Droid>();
        BattleArena arena = new BattleArena();
        printCommandList();
        Scanner scanner = new Scanner(System.in);
        short command = 0;
        short droidType = 0;

        while(true){
            System.out.println("\n-----------");
            System.out.print("�������: ");
            command = scanner.nextShort();
            System.out.println("-----------\n");
            switch (command){

                case 1: {
                    droidsTypeList();
                    System.out.print("����: ");
                    droidType = scanner.nextShort();

                    Droid droid;

                    switch(droidType){
                        case 1:{
                            droid = createDroid(droidType);
                            droidsList.add(droid);
                            break;
                        }
                        case 2:{
                            droid = createDroid(droidType);
                            droidsList.add(droid);
                            break;
                        }
                        case 3:{
                            droid = createDroid(droidType);
                            droidsList.add(droid);
                            break;
                        }
                    }
                    break;
                }
                case 2:{
                    printDroidsList(droidsList);
                    break;
                }
                /* ������ ��� 1 �� 1 */
                case 3:{

                    System.out.println("\t������� ���� ����� � ������\n");
                    printDroidsList(droidsList);
                    System.out.print("\n����� �������: ");
                    short droid1_idx = scanner.nextShort();
                    System.out.print("����� �������: ");
                    short droid2_idx = scanner.nextShort();
                    System.out.print("\n��������� ���������� ���?\n1 - ���, 0 - �\n>> ");
                    printDmgMsg = scanner.nextInt();

                    arena.startBattle(droidsList.get(droid1_idx-1), droidsList.get(droid2_idx-1));
                    refreshHealth(droidsList);
                    break;
                }
                /* ������ ��� ������� �� ������� */
                case 4:{

                    ArrayList<Droid> team1 = new ArrayList<Droid>();
                    ArrayList<Droid> team2 = new ArrayList<Droid>();

                    createTeams(team1, team2, droidsList);

                    System.out.println("\n\t������� �1\n");
                    for (int i = 0; i < team1.size(); i++) {
                        System.out.println("\t| " + team1.get(i).toString());
                    }
                    System.out.println("\n\t������� �2\n");
                    for (int i = 0; i < team2.size(); i++) {
                        System.out.println("\t| " + team2.get(i).toString());
                    }

                    System.out.print("\n��������� ���������� ���?\n1 - ���, 0 - �\n>> ");
                    printDmgMsg = scanner.nextInt();
                    arena.startBattle(team1, team2);
                    refreshHealth(droidsList);
                    break;
                }
                case 5: {
                    System.out.println("\t�������� � ���.");
                    System.exit(0);
                }
            }
        }


    }

    Droid createDroid(int type){

        Scanner scanner = new Scanner(System.in);
        String name = "Empty";
        double health = 0;
        int minDamage = 0;
        int maxDamage = 0;
        int armour = 0;

        System.out.print("\n| ��'�: ");
        name = scanner.nextLine();
        System.out.print("| ������'�: ");
        health = scanner.nextDouble();
        System.out.print("| ̳�. ����: ");
        minDamage = scanner.nextInt();
        System.out.print("| ����. ����: ");
        maxDamage = scanner.nextInt();
        System.out.print("| �����: ");
        armour = scanner.nextInt();

        Droid droid = null;

        switch (type){
            /* ��������� ���������� ����� */
            case 1:{
                droid = Droid.newBuilder().setName(name).setHealth(health).setMinDamage(minDamage)
                        .setMaxDamage(maxDamage).setArmour(armour).build();
                break;
            }
            /* ��������� �������� ����� */
            case 2:{
                weaponTypeList();
                System.out.print("| �����: ");
                short weaponType = 0;
                weaponType = scanner.nextShort();
                Weapon weapon = null;

                switch (weaponType){
                    case 1:{
                        weapon = new MiniBlaster();
                        break;
                    }
                    case 2:{
                        weapon = new Machinegun();
                        break;
                    }
                    case 3:{
                        weapon = new PlasmaRifle();
                        break;
                    }
                }

                droid = Soldier.newBuilder().setWeapon(weapon).setName(name).setHealth(health).setMinDamage(minDamage).setMaxDamage(maxDamage)
                        .setArmour(armour).build();
                break;
            }
            /* ��������� �������� */
            case 3:{
                System.out.print("| �����������: ");
                double regen = 0.0;
                regen = scanner.nextDouble();
                droid = Engineer.newBuilder().setRegen(regen).setName(name).setHealth(health).setMinDamage(minDamage)
                        .setMaxDamage(maxDamage).setArmour(armour).build();
                break;
            }

        }

        return droid;
    }

    void printDroidsList(ArrayList<Droid> droidsList){
        for (int i = 0; i < droidsList.size(); i++) {
            System.out.println("\t" + '['+ (i+1) + "] " + droidsList.get(i).toString());
        }
    }

    void createTeams(ArrayList<Droid> team1, ArrayList<Droid> team2, ArrayList<Droid> droidsList){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\t��������� ����� �� 2 �������\n\t��� ��������" +
                " ��������, ������ 0\n");
        printDroidsList(droidsList);
        System.out.print("\n������� �1:\n>> ");

        while(true){
            int idx = scanner.nextInt();
            if(idx<1) break;
            team1.add(droidsList.get(idx-1));
        }

        System.out.print("\n������� �2:\n>> ");
        while(true){
            int idx = scanner.nextInt();
            if(idx<1) break;
            team2.add(droidsList.get(idx-1));
        }

    }

    void refreshHealth(ArrayList<Droid> droidsList){
        for (int i = 0; i < droidsList.size(); i++) {
            if(droidsList.get(i).getHealth()!=droidsList.get(i).getPreFighthealth()){
                droidsList.get(i).setHealth(droidsList.get(i).getPreFighthealth());
            }
        }
    }

}
