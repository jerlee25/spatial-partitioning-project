import java.util.*;
import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MyWorld extends World {    
    private Partitioner partitioner;
    private List<Battler> battlers;

    public GreenfootImage red;
    public GreenfootImage green;
    public GreenfootImage blue;

    public MyWorld() {
        super(600, 400, 1);

        // quadTree setup
        partitioner = new Partitioner(this);

        // intializing battlers
        battlers = new ArrayList<>();

        for (int i = 0; i < 300; i++) {
            Battler battler = new Battler(Battler.Type.values()[Greenfoot.getRandomNumber(3)]);
            addObject(battler, Greenfoot.getRandomNumber(600), Greenfoot.getRandomNumber(400));
            battlers.add(battler);
        }

        // set up sprites
        red = new GreenfootImage("red.jpg");
        red.scale(5, 5);
        green = new GreenfootImage("green.png");
        green.scale(5, 5);
        blue = new GreenfootImage("blue.png");
        blue.scale(5, 5);

    }

    public Partitioner getPartitioner() {
        return partitioner;
    }

    // this should be the only act() method in the project, and will call update()
    // on all actors
    public void act() {
        // Player spawning new battlers
        if (Greenfoot.isKeyDown("1")) {
            for (int i = 0; i < 30; i++) {
                Battler battler = new Battler(Battler.Type.RED);
                addObject(battler, Greenfoot.getRandomNumber(600), Greenfoot.getRandomNumber(400));
                battlers.add(battler);
            }
        }
        if (Greenfoot.isKeyDown("2")) {
            for (int i = 0; i < 30; i++) {
                Battler battler = new Battler(Battler.Type.GREEN);
                addObject(battler, Greenfoot.getRandomNumber(600), Greenfoot.getRandomNumber(400));
                battlers.add(battler);
            }
        }
        if (Greenfoot.isKeyDown("3")) {
            for (int i = 0; i < 30; i++) {
                Battler battler = new Battler(Battler.Type.BLUE);
                addObject(battler, Greenfoot.getRandomNumber(600), Greenfoot.getRandomNumber(400));
                battlers.add(battler);
            }
        }
        if (Greenfoot.isKeyDown("4")){
            for (Battler battler : battlers) {
                removeObject(battler);
            }
            battlers.clear();
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
      /* for (Battler battler : battlers) {
            if (battler.getType() == Battler.Type.RED){
                battler.update();
            }

        }
        for (Battler battler : battlers) {
            if (battler.getType() == Battler.Type.BLUE){
                battler.update();
            }
        }
        for (Battler battler : battlers) {
            if (battler.getType() == Battler.Type.GREEN){
                battler.update();
            }
        }*/
       
         

        /*
         * 
         * 
         * // partitioner visual is updated
         * partitioner.drawGridVisual();
         */

        // shows battler count
        showText("Battlers: " + battlers.size(), 60, 20);   
    }
}
