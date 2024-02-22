import java.util.*;

//Grid-based spatial partitioning
public class Partitioner {
    public static final int gridWidth;
    public static final int gridHeight;
    
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
    
    public List<Battler> query(int x, int y) {
        
    }
}