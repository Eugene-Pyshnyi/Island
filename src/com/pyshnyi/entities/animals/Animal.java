package com.pyshnyi.entities.animals;

import com.pyshnyi.entities.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.pyshnyi.annotation.Prop;

import java.util.concurrent.ThreadLocalRandom;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class Animal extends Entity {

    private final int MAX_ACTION_CHANCE_INDEX = 100;

    @Prop(title = "weight", priority = 4)
    private double weight;
    @Prop(title = "maxCount", priority = 1)
    private int maxCount;
    @Prop(title = "speed", defaultValue = "1", priority = 2)
    private int speed;
    @Prop(title = "kgToBeFull", priority = 0)
    private double kgToBeFull;
    @Prop(title = "unicode", priority = 3)
    private String unicode;
    private double health;

    protected Animal(double weight, int maxCount, int speed, double kgToBeFull) {
        this.weight = weight;
        this.maxCount = maxCount;
        this.speed = speed;
        this.health = kgToBeFull;
        this.kgToBeFull = kgToBeFull;
        this.unicode = "Hello";
    }
    protected Animal(double weight, int maxCount, int speed, double kgToBeFull, String unicode) {
        this.weight = weight;
        this.maxCount = maxCount;
        this.speed = speed;
        this.health = kgToBeFull;
        this.kgToBeFull = kgToBeFull;
        this.unicode = unicode;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public int getMaxCount() {
        return maxCount;
    }
    public abstract Animal reproduce();

    public void eat(Entity food) {
        if (food.getWeight() >= this.getKgToBeFull()) {
            this.setHealth(this.getKgToBeFull());
        } else {
            double hunger = this.getHealth() + this.getWeight();
            this.setHealth(hunger);
        }
    }

    public Action action() {
        Action action = Action.values()[ThreadLocalRandom.current().nextInt(Action.values().length)];
        boolean isActiveAction = ThreadLocalRandom.current().nextInt(100) < action.getActionChance();
        if (isActiveAction) {
            return action;
        } else {
            return Action.SLEEP;
        }
    }
    public Direction move() {
        return Direction.values()[ThreadLocalRandom.current().nextInt(Direction.values().length)];
    }
    public Action actionChoice() {
        Action action = Action.values()[ThreadLocalRandom.current().nextInt(Action.values().length)];
        boolean isActiveAction = ThreadLocalRandom.current().nextInt(MAX_ACTION_CHANCE_INDEX) < action.getActionChance();
        if (isActiveAction) {
            return action;
        }
        return action.SLEEP;
    }
    public boolean isDead() {
        return true;
    }
}
