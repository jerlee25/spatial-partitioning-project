import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

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

    public Battler(Type type) {
        // Set image based on type
        this.type = type;
        GreenfootImage sprite = new GreenfootImage("green.png");
        switch (type) {
            case GREEN:
                sprite = new GreenfootImage("green.png");
                break;
            case RED:
                sprite = new GreenfootImage("red.jpg");
                break;
            case BLUE:
                sprite = new GreenfootImage("blue.png");
                break;
        }
        sprite.scale(3,3);
        setImage(sprite);
    }

    private Battler locate(Type target) {
        // Find nearest battler of target
        return null;
    }

    /**
     * Act - do whatever the Battler wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        // Die if intersecting with a winning battler
        List<Battler> battlers = getIntersectingObjects(Battler.class);
        for (Battler battler : battlers) {
            if (target(battler.getType()) == getType()) {
                getWorld().removeObject(this);
                return;
            }
        }

    }
}
