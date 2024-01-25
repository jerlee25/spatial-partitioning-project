import javax.crypto.spec.GCMParameterSpec;

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    private QuadTree quadTree;
    
    //Note: please make sure world is odd x odd size because i don't wanna fix the bug
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(601, 401, 1);
        quadTree = new QuadTree(this);
    }
    
    public QuadTree getQuadTree() {
        return quadTree;
    }

    //update: the order in which act methods are called is very important.
    //Unless there's an easier way, I think the world should have the only act method,
    //and have it update everything in order
    public void act(){
        // 0.5% chance to summon a new battler
        if (Greenfoot.getRandomNumber(200)<1){
            addObject(new Battler(Battler.Type.values()[Greenfoot.getRandomNumber(3)]), Greenfoot.getRandomNumber(600), Greenfoot.getRandomNumber(400));
        }
    }
}
