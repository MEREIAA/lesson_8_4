package kg.geeks.game.players;

import static kg.geeks.game.general.RPG_Game.random;

public class Avenger extends Hero {
    private boolean protectionActive = false;
    public Avenger(String name, int health, int damage) {
        super(name, health, damage, SuperAbility.AVENGER);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        if (random.nextInt(100) < 20) { // 20% шанс на активацию защиты
            protectionActive = true;
            System.out.println("Avenger активировал защиту для всей команды!");
        } else {
            protectionActive = false;
        }
    }

    public boolean isProtectionActive() {
        return protectionActive;
    }
}
