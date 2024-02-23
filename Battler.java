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

    private MyWorld myWorld() {
        return (MyWorld) getWorld();
    }

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
        this.type = type;

    }

    protected void addedToWorld(World world) {
        changeType(type);
    }

    public void changeType(Type type) {
        this.type = type;
        switch (type) {
            case GREEN:
                setImage(myWorld().green);
                break;
            case RED:
                setImage(myWorld().red);
                break;
            case BLUE:
                setImage(myWorld().blue);
                break;
        }

    }

    private List<Battler> locateNearBattlers(int r) {
        return myWorld().getPartitioner().query(this, r, getTarget());

    }

    private double getDist(Actor o) {
        return Math.sqrt(Math.pow(getX() - o.getX(), 2) + Math.pow(getY() - o.getY(), 2));
    }

    private Battler locate(Type target) {
        // since battlers are often clustered, we often won't
        // need to check the whole radius. also here we can just
        // have the battler target a random one
        List<Battler> nearBattlers = locateNearBattlers(10); 
        if (nearBattlers.size() != 0) {
            return nearBattlers.get(Greenfoot.getRandomNumber(nearBattlers.size()));

        }

        // check full range
        nearBattlers = locateNearBattlers(50);
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
        List<Battler> battlers = myWorld().getPartitioner().query(this, 3, target(getTarget()));
        if (battlers.size() > 0) {
            changeType(target(getTarget()));
        }

        Battler closestTarget = locate(getTarget());
        if (closestTarget != null) {
            turnTowards(closestTarget.getX(), closestTarget.getY());
        }

        // Introduce some randomness
        turn(20 - Greenfoot.getRandomNumber(40));

        // Move away from edge
        if (getX() <= 15)
            setRotation(0);
        if (getY() <= 15)
            setRotation(90);
        if (getX() >= getWorld().getWidth() - 15)
            setRotation(180);
        if (getY() >= getWorld().getHeight() - 15)
            setRotation(270);

        move(5 + Greenfoot.getRandomNumber(5));

    }
}
