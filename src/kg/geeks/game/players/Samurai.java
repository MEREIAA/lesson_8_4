package kg.geeks.game.players;

import static kg.geeks.game.general.RPG_Game.random;

public class Samurai extends Hero{

    public Samurai(String name, int health, int damage) {
        super(name, health, damage, SuperAbility.SAMURAI);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        boolean isVirus = random.nextBoolean();
        if (isVirus) {
            boss.setHealth(boss.getHealth() - this.getDamage()); // Вирус наносит урон боссу
            System.out.println("Вирус нанёс урон");
        } else {
            boss.setHealth(boss.getHealth() + this.getDamage()); // Вакцина лечит босса
            System.out.println("Вакцина вылечила босса");

        }
    }
}
