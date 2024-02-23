import java.util.*;

import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MyWorld extends World {
    private Partitioner partitioner;
    private List<Battler> battlers;

    public MyWorld() {
        // for accuracy, make sure this is odd x odd
        super(601, 401, 1);

        // quadTree setup
        partitioner = new Partitioner(this);
        
        // intializing battlers
        battlers = new ArrayList<>();
        
        for (int i=0;i<300;i++) {
            Battler battler = new Battler(Battler.Type.values()[Greenfoot.getRandomNumber(3)]);
            addObject(battler, Greenfoot.getRandomNumber(600), Greenfoot.getRandomNumber(400));
            battlers.add(battler);
        }
    }

    public Partitioner getPartitioner() {
        return partitioner;
    }

    // this should be the only act() method in the project, and will call update() on all actors
    public void act() {
        // Player spawning new battlers
        if (Greenfoot.isKeyDown("1")){
             for (int i=0;i<30;i++){
                Battler battler = new Battler(Battler.Type.RED);
                addObject(battler, Greenfoot.getRandomNumber(600), Greenfoot.getRandomNumber(400));
                battlers.add(battler);
            }
        }
         if (Greenfoot.isKeyDown("2")){
             for (int i=0;i<30;i++){
                Battler battler = new Battler(Battler.Type.GREEN);
                addObject(battler, Greenfoot.getRandomNumber(600), Greenfoot.getRandomNumber(400));
                battlers.add(battler);
            }
        }
         if (Greenfoot.isKeyDown("3")){
             for (int i=0;i<30;i++){
                Battler battler = new Battler(Battler.Type.BLUE);
                addObject(battler, Greenfoot.getRandomNumber(600), Greenfoot.getRandomNumber(400));
                battlers.add(battler);
            }
        }

        // partitioner is cleared
        
                
        partitioner.clear();

        // battlers are added to the partitioner
        for (Battler battler : battlers) {
            partitioner.addBattler(battler);
        }
        
        // battlers are updated
        for (Battler battler : battlers) {
            battler.update();
        }
   /*     


        // partitioner visual is updated
        partitioner.drawGridVisual();
        */
    }
}
