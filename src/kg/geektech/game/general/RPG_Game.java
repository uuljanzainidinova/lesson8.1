package kg.geektech.game.general;

import kg.geektech.game.players.*;
import java.util.Random;

public class RPG_Game {
    public static Random random = new Random();

    public static void start() {

        Boss boss = new Boss(700, 50);

        Warrior warrior = new Warrior(290, 15);
        Medic doc = new Medic(200, 5, 15);
        Magic magic = new Magic(270, 20);
        Berserk berserk = new Berserk(240, 20);
        Medic assistant = new Medic(280, 10, 5);
        Thor thor = new Thor(240, 30);
        TrickyBastard trickyBastard = new TrickyBastard(190,25);
        Antman antman = new Antman(210,16);
        Hero[] heroes = {warrior, doc, magic, berserk, assistant, thor, trickyBastard, antman};

        printStatistics(heroes, boss);

        while (!isGameFinished(heroes, boss)) {
            round(heroes, boss);
        }
    }

    private static void round(Hero[] heroes, Boss boss) {
        if ( boss.getHealth() > 0 && !boss.isDeafen()){
            heroesHit(heroes, boss);
        }
        bossHits(heroes, boss);
        applySuperPowers(heroes, boss);
        printStatistics(heroes, boss);
    }

    private static void bossHits(Hero[] heroes, Boss boss) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0 && boss.getDamage() >0) {
                heroes[i].setHealth(
                        heroes[i].getHealth() - boss.getDamage());
            }
        }

    }

    private static void applySuperPowers(Hero[] heroes, Boss boss) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0) {
                heroes[i].applySuperPower(heroes, boss);

            }
        }
    }

    private static void heroesHit(Hero[] heroes, Boss boss) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0) {
                boss.setHealth(
                        boss.getHealth() - heroes[i].getDamage());
            }
        }
    }

    private static boolean isGameFinished(Hero[] heroes, Boss boss) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss won!!!");
        }
        return allHeroesDead;
    }

    private static void printStatistics(Hero[] heroes, Boss boss) {
        System.out.println("______________");
        System.out.println("Boss health: " + boss.getHealth() +
                ", damage: " + boss.getDamage());
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i].getClass().getSimpleName() + " health: "
                    + heroes[i].getHealth() +
                    ", damage: " + heroes[i].getDamage());
        }
        System.out.println("______________");
    }

}
