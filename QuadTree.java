import greenfoot.*;

public class QuadTree {
    private Rect rect;
    
    public QuadTree(World world) {
        Vector worldSize = new Vector(world.getWidth(), world.getHeight());
        Vector halfWorldSize = Vector.divide(worldSize, 2);
        rect = new Rect(halfWorldSize, worldSize);
    }
}