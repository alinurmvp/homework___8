package kg.geeks.game.logic;

import kg.geeks.game.players.*;

import java.util.Random;

public class RpgGame {
    public static Random random = new Random();
    private static int roundNumber;

    public static void startGame() {
        Boss boss = new Boss(1000, 50, "Kraken");

        Warrior warrior1 = new Warrior(270, 10, "Luntik");
        Warrior warrior2 = new Warrior(280, 15, "Hercules");
        Magic magic = new Magic(290, 10, "Merlin");
        Berserk berserk = new Berserk(260, 10, "Kruella");
        Medic doc = new Medic(250, 5, 15, "Haus");
        Medic assistant = new Medic(290, 5, 5, "Avicenna");
        Whitcher whitcher = new Whitcher(240,0,"Whitcher");
        Hucker hucker = new Hucker(250,20,"Hacker");

        Hero[] heroes = {warrior1, warrior2, doc, magic, berserk, assistant,whitcher,hucker};
        showStatistics(boss, heroes);

        while (!isGameOver(boss, heroes)) {
            playRound(boss, heroes);
        }
    }

    private static boolean isGameOver(Boss boss, Hero[] heroes) {
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

    private static void playRound(Boss boss, Hero[] heroes) {
        roundNumber++;
        boss.chooseDefence();
        boss.attack(heroes);
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[7].getHealth() > 0 && boss.getHealth() > 0 &&
                    boss.getDefence() != heroes[7].getAbility()) {
                heroes[7].attack(boss);
                if(roundNumber % 2 != 0 && heroes[1] == heroes[7]){
                    heroes[i].applySuperPower(boss, heroes);
                }
                if(heroes[i] != heroes[7]){
                    heroes[i].applySuperPower(boss, heroes);
                }
            }
        }

        showStatistics(boss, heroes);
    }

    private static void showStatistics(Boss boss, Hero[] heroes) {
        System.out.println("ROUND " + roundNumber + " --------------");
        System.out.println(boss);
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i]);
        }
    }
}
