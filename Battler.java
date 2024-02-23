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
        sprite.scale(5,5);
        setImage(sprite);
    }
    private void changeType(Type type){
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
        sprite.scale(5,5);
        setImage(sprite);
    }
    
    private List<Battler> locateNearBattlers(){
        // CHANGE ONCE GRID WORKS TO USE SPATIAL PARTITIONS
        List <Battler> nearBattlers = new ArrayList<Battler>();
        nearBattlers = getNeighbours(50,true,Battler.class);
        return nearBattlers;
    
    }
    
    private double getDist(Actor o){
        return Math.sqrt(Math.pow(getX() - o.getX(),2)+Math.pow(getY() - o.getY(),2));
    }
    
    private Battler locate(Type target) {
        List<Battler> nearBattlers = locateNearBattlers();
        Battler closestBattler = null;
        double closestDist = 1000000;
        for (Battler nearBattler:nearBattlers){
            if (target == nearBattler.getType() && getDist(nearBattler) < closestDist){
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
        List<Battler> battlers = getIntersectingObjects(Battler.class);
        for (Battler battler : battlers) {
            if (target(battler.getType()) == getType()) {
                changeType(battler.getType());
                
            }
        }
        
        if (getX() <= 15 || getY() <=15 || getX() >= getWorld().getWidth()-15 || getY() >=getWorld().getHeight()-15  ){
            turn(80);
        
        }
        Battler closestTarget = locate(getTarget());
        if (closestTarget!=null){
             turnTowards(closestTarget.getX(),closestTarget.getY());
        }
        else{
            turn(10-Greenfoot.getRandomNumber(20));
        
        }
        
        
        
        move(5 + Greenfoot.getRandomNumber(5));
        
       

    }
}
