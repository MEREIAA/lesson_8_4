package kg.geeks.game.general;

import kg.geeks.game.players.*;

import java.util.Random;

public class RPG_Game {
    public static Random random = new Random();
    private static int roundNumber;

    public static void startGame() {
        Boss boss = new Boss("Black", 1000, 50);
        Warrior warrior1 = new Warrior("Rick", 280, 10);
        Warrior warrior2 = new Warrior("Arthur", 270, 15);
        Magic magic = new Magic("Potter", 260, 10);
        Medic doc = new Medic("Haus", 250, 5, 15);
        Medic assistant = new Medic("Levin", 300, 5, 5);
        Berserk berserk = new Berserk("Valera", 240, 10);
        Samurai samurai = new Samurai("Samurai", 200, 10);
        Avenger avenger = new Avenger("Avenger", 200,5);
        Hacker hacker = new Hacker("Hacker",200,10);

        Hero[] heroes = { magic, samurai, avenger,hacker};

        printStatistics(boss, heroes);

        while (!isGameOver(boss, heroes)) {
            playRound(boss, heroes, avenger);
        }
    }

    public static void playRound(Boss boss, Hero[] heroes,Avenger avenger) {
        roundNumber++;
        boss.chooseDefence();
        if (!avenger.isProtectionActive()){
            boss.attack(heroes);
        }
        for (Hero hero : heroes) {
            if (hero.getHealth() > 0 && boss.getHealth() > 0
                    && hero.getAbility() != boss.getDefence()) {
                hero.attack(boss);
                hero.applySuperPower(boss, heroes);
            }
        }
        printStatistics(boss, heroes);
    }

    private static boolean isGameOver(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (Hero hero : heroes) {
            if (hero.getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss won!!!");
            return true;
        }
        return false;
    }

    private static void printStatistics(Boss boss, Hero[] heroes) {
        System.out.println("--------------------------");
        System.out.println("ROUND " + roundNumber);
        System.out.println(boss);
        for (Hero hero : heroes) {
            System.out.println(hero);
        }
    }
}