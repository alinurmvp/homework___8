package kg.geeks.game.players;

import kg.geeks.game.logic.RpgGame;

public class Magic extends Hero{
    public Magic(int health, int damage,String name) {
        super(health, damage,SuperAbility.BOOST,name);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int boost = RpgGame.random.nextInt(10);
        for (Hero hero : heroes) {
            if (hero.getDamage() != 0) {
                hero.setDamage(hero.getDamage() + boost);

            }
        }System.out.println("Magic " + this.getName() + " boosted the team " + boost);
    }
}
