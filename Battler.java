import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Battler here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Battler extends Actor {
    static enum Type {
        GREEN, RED, BLUE
    };

    private Type type;

    public static Type target(Type type) {
        switch (type) {
            case GREEN:
                return Type.BLUE;
            case RED:
                return Type.GREEN;
            case BLUE:
                return Type.RED;
        }
        return Type.RED;
    }

    public Type getType() {
        return type;
    }

    public Type getTarget() {
        return target(getType());
    }

    public Battler(Type type) {
        changeType(type);

    }

    public void changeType(Type type) {
        this.type = type;
        switch (type) {
            case GREEN:
                setImage(getWorld().green);
                break;
            case RED:
                setImage(getWorld().red);
                break;
            case BLUE:
                setImage(getWorld().blue);
                break;
        }

    }

    private List<Battler> locateNearBattlers(int r) {
        return getWorld().parttioner.query(this, r, getTarget());

    }

    private double getDist(Actor o) {
        return Math.sqrt(Math.pow(getX() - o.getX(), 2) + Math.pow(getY() - o.getY(), 2));
    }

    private Battler locate(Type target) {
        List<Battler> nearBattlers = locateNearBattlers(10); // since battlers are often clustered, we don't need to check that far
        // and the targeting doesn't matter much at that point since they're almost overlapping anyway, so just return the first
        if (nearBattlers.size() != 0) {   return nearBattlers[0];   }
        nearBattlers = locateNearBattlers(50); // otherwise check beyond for the nearest
        Battler closestBattler = null;
        double closestDist = 1000000;
        for (Battler nearBattler : nearBattlers) {
            if (getDist(nearBattler) < closestDist) {
                closestBattler = nearBattler;
            }
        }
        return closestBattler;
    }

    /**
     * The spacial partitioning won't work if this is act()...
     * it needs to be a method that's called manually by the world on all battlers
     * otherwise, this may be out of sync with the spacial partitioning
     */
    public void update() {
        // Die if intersecting with a winning battler
        List<Battler> battlers = getWorld().partitioner.query(this, 5, target(getTarget()));
        if (battlers.size() > 0) {
            changeType(target(getTarget()));
        }

        if (getX() <= 15 || getY() <= 15 || getX() >= getWorld().getWidth() - 15
                || getY() >= getWorld().getHeight() - 15) {
            turn(80);

        }
        Battler closestTarget = locate(getTarget());
        if (closestTarget != null) {
            turnTowards(closestTarget.getX(), closestTarget.getY());
        } else {
            turn(10 - Greenfoot.getRandomNumber(20));

        }

        move(5 + Greenfoot.getRandomNumber(5));

    }
}
