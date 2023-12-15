package com.entities.animals;

import annotation.Prop;
import com.entities.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.concurrent.ThreadLocalRandom;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class Animal extends Entity {
    @Prop(title = "weight", priority = 1)
    private double weight;
    @Prop(title = "maxCountOnCell", priority = 2)
    private int maxCountOnCell;
    @Prop(title = "speed", defaultValue = "1", priority = 3)
    private int speed;
    @Prop(title = "kgToBeFull", priority = 4)
    private double kgToBeFull;
    @Prop(title = "unicode", priority = 5)
    private String unicode;
    private double health;

    public Animal(double weight, int maxCountOnCell, int speed, double kgToBeFull) {
        this.weight = weight;
        this.maxCountOnCell = maxCountOnCell;
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
    public int getMaxCountOnCell() {
        return maxCountOnCell;
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
}
