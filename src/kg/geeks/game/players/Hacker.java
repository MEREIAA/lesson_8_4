package kg.geeks.game.players;

import java.util.Random;

public class Hacker extends Hero {
    private int healthStealAmount = 30; // Количество здоровья, которое крадет у босса
    private boolean stealThisRound = false; //  для выполнения кражи через раунд
    private Random random = new Random();

    public Hacker(String name, int health, int damage) {
        super(name, health, damage, SuperAbility.HACKER);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        if (stealThisRound) {
            Hero randomHero = heroes[random.nextInt(heroes.length)]; // Случайный герой для передачи здоровья
            if (boss.getHealth() > healthStealAmount) {
                boss.setHealth(boss.getHealth() - healthStealAmount); // Забираем здоровье у босса
                randomHero.setHealth(randomHero.getHealth() + healthStealAmount); // Передаем здоровье герою
                System.out.println("Hacker забрал " + healthStealAmount + " здоровья у босса и передал " + randomHero.getName());
            }
        }
        stealThisRound = !stealThisRound; // Меняем флаг, чтобы кража происходила через раунд
    }
}