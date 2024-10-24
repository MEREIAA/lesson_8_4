package kg.geeks.game.players;

public class Magic extends Hero {

    private int roundCount = 0;

    public Magic(String name, int health, int damage) {
        super(name, health, damage, SuperAbility.BOOST);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        if (roundCount < 4) {
            for (Hero hero : heroes) {
                hero.setDamage(hero.getDamage() + 5);
            }
            roundCount++;
        } else if(roundCount==4){
            roundCount++;
            for (Hero hero:heroes){
                hero.setDamage(hero.getDamage()- 20);
            }
        }
    }
}
