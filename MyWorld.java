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
    //Note: please make sure world is odd x odd size because i don't wanna fix the bug
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(601, 401, 1); 
    }

    public void act(){
        if (Greenfoot.getRandomNumber(30)<1){
            addObject(new Battler(Battler.Type.values()[Greenfoot.getRandomNumber(3)]), Greenfoot.getRandomNumber(400), Greenfoot.getRandomNumber(400));
        }
    }
}
