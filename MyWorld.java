import javax.crypto.spec.GCMParameterSpec;

import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class MyWorld extends World {
    private Partitioner partitioner;

    public MyWorld() {
        // for accuracy, make sure this is odd x odd
        super(601, 401, 1);

        // quadTree setup
        partitioner = new Partitioner(this);
        
        // intializing battlers
        for (int i=0;i<300;i++){
        
            addObject(new Battler(Battler.Type.values()[Greenfoot.getRandomNumber(3)]), Greenfoot.getRandomNumber(600),
                Greenfoot.getRandomNumber(400));
        }
    }

    public Partitioner getPartitioner() {
        return partitioner;
    }

    // update: the order in which act methods are called is very important in this
    // project.
    // Unless there's an easier way, I think the world should have the only act
    // method,
    // and have it update everything in order
    // this should be the only act() method in the project, and will call update()
    // on all actors
    public void act() {
        // Player spawning new battlers
        
        if (Greenfoot.isKeyDown("1")){
             for (int i=0;i<30;i++){
        
                addObject(new Battler(Battler.Type.RED), Greenfoot.getRandomNumber(600),
                    Greenfoot.getRandomNumber(400));
            }
        }
         if (Greenfoot.isKeyDown("2")){
             for (int i=0;i<30;i++){
        
                addObject(new Battler(Battler.Type.GREEN), Greenfoot.getRandomNumber(600),
                    Greenfoot.getRandomNumber(400));
            }
        }
         if (Greenfoot.isKeyDown("3")){
             for (int i=0;i<30;i++){
        
                addObject(new Battler(Battler.Type.BLUE), Greenfoot.getRandomNumber(600),
                    Greenfoot.getRandomNumber(400));
            }
        }
        
        // 10% chance to summon a new battler
        // addObject(new Battler(Battler.Type.values()[Greenfoot.getRandomNumber(3)]), Greenfoot.getRandomNumber(600),
                //Greenfoot.getRandomNumber(400));       
                
        // game loop:
        // quadTree is cleared
        // battlers add themselves to the quad tree
        // battlers act() and calculate their movement
        // battlers move
        // quadtree visual is updated
    }
}
