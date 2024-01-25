import greenfoot.*;

//created in the MyWorld class
public class QuadTreeVisualizer extends Actor {
    private QuadTree quadTree;
    
    public QuadTreeVisualizer(World world, QuadTree quadTree) {
        this.quadTree = quadTree;
        setImage(new GreenfootImage(world.getWidth(), world.getHeight()));
    }

    public void update() {
        QuadTree quadTree = ((MyWorld)getWorld()).getQuadTree();
        Rect rect = quadTree.getRect();

        GreenfootImage image = getImage();
        image.clear();
        image.setColor(Color.BLUE);
        
        image.drawRect(rect.position.x, rect.position.y, 10, 10);
        
        setImage(image);
    }
    
    
}