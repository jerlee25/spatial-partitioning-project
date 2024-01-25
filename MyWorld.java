import javax.crypto.spec.GCMParameterSpec;

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World {
    private QuadTree quadTree;

    public MyWorld()
    {
        //for accuracy, make sure this is odd x odd
        super(601, 401, 1);
        
        //quadTree setup
        Vector size = new Vector(getWidth(), getHeight());
    }
    
    public QuadTree getQuadTree() {
        return quadTree;
    }

    //update: the order in which act methods are called is very important in this project.
    //Unless there's an easier way, I think the world should have the only act method,
    //and have it update everything in order
    //this should be the only act() method in the project, and will call update() on all actors
    public void act(){
        // 0.5% chance to summon a new battler
        if (Greenfoot.getRandomNumber(200)<1){
            addObject(new Battler(Battler.Type.values()[Greenfoot.getRandomNumber(3)]), Greenfoot.getRandomNumber(600), Greenfoot.getRandomNumber(400));
        }
        
        //game loop:
        //quadTree is cleared
        //battlers add themselves to the quad tree and calculate movement
        //battlers act
        //quadtree visual is updated
    }
}
