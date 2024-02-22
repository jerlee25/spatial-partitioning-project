import java.util.*;

//Grid-based spatial partitioning
public class Partitioner {
    public static final int gridWidth = 20;
    public static final int gridHeight = 20;
    
    private MyWorld world;
    private List<Battler>[][] grid;
    
    public Partitioner(MyWorld world) {
        this.world = world;
        grid = new ArrayList[gridWidth][gridHeight];
        clear();
    }

    public void clear() { 
        for (int x = 0; x < gridWidth; x++) {      
            for (int y = 0; y < gridHeight; y++) {
                grid[x][y] = new ArrayList<>();
            }
        }
    }
    
    public void addBattler(Battler battler) {
        int x = worldToGrid(battler.getX(), world.getWidth(), gridWidth);    
        int y = worldToGrid(battler.getY(), world.getHeight(), gridHeight);
    }
    
    public List<Battler> query(Battler sourceBattler, int radius) {
        int worldX = sourceBattler.getX();
        int worldY = sourceBattler.getY();
        
        int gridX = worldToGrid(sourceBattler.getX(), world.getWidth(), gridWidth);
        int gridY = worldToGrid(sourceBattler.getY(), world.getHeight(), gridHeight);
        
        int xRadius
    }
    
    //converts a world position to a grid position
    private int worldToGrid(int worldCoord, int worldSize, int gridSize) {
        int cellSize = worldSize / gridSize;
        return (worldCoord / cellSize);
    }
}