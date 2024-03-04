package kg.geeks.game.players;

import kg.geeks.game.logic.RpgGame;

public class Hucker extends  Hero {


    public Hucker(int health, int damage, String name) {
        super(health, damage, SuperAbility.TAKING_HEALTH, name);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int cheating = RpgGame.random.nextInt(100);
        int randomHero = RpgGame.random.nextInt(heroes.length);
        boss.setHealth(boss.getHealth() - cheating);
        heroes[randomHero].setHealth(heroes[randomHero].getHealth() + cheating);
                System.out.println("Hacker " + this.getName() + " took the boss's health " +
                        cheating + " and gave " + heroes[randomHero].getName());

    }
}
