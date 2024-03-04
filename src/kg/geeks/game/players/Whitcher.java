package kg.geeks.game.players;

public class Whitcher extends  Hero {


    public Whitcher(int health, int damage, String name) {
        super(health, damage, SuperAbility.SWITCHING, name);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        if(getHealth() > 0){
            for (Hero hero : heroes) {
                if (hero.getName() != getName() && hero.getHealth() == 0) {
                    hero.setHealth( getHealth());
                    setHealth(0);
                }
            }
        }

    }
}
