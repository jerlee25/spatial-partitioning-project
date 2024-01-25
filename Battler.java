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
        ROCK, PAPER, SCISSORS
    };

    private Type type;

    public static Type target(Type type) {
        switch (type) {
            case ROCK:
                return Type.SCISSORS;
            case PAPER:
                return Type.ROCK;
            case SCISSORS:
                return Type.PAPER;
        }
        return Type.PAPER;
    }

    public Type getType() {
        return type;
    }

    public Battler(Type type) {
        // Set image based on type
        this.type = type;
        GreenfootImage sprite = new GreenfootImage("rock.png");
        switch (type) {
            case ROCK:
                sprite = new GreenfootImage("rock.png");
                break;
            case PAPER:
                sprite = new GreenfootImage("paper.jpg");
                break;
            case SCISSORS:
                sprite = new GreenfootImage("scissors.png");
                break;
        }
        sprite.scale(50,50);
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