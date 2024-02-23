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
        grid[x][y].add(battler);
    }
    
    public List<Battler> query(Battler sourceBattler, int radius, Battler.Type type) {
        int worldX = sourceBattler.getX();
        int worldY = sourceBattler.getY();
        
        int gridXMin = worldToGrid(worldX - radius, world.getWidth(), gridWidth);
        int gridYMin = worldToGrid(worldY - radius, world.getHeight(), gridHeight);
        int gridXMax = worldToGrid(worldX + radius, world.getWidth(), gridWidth);
        int gridYMax = worldToGrid(worldY + radius, world.getHeight(), gridHeight);
        
        List<Battler> battlers = new ArrayList<>();
        
        for (int x = gridXMin; x <= gridXMax; x++) {
            for (int y = gridYMin; y <= gridYMax; y++) {
                if (!isOnGrid(x, gridWidth) || !isOnGrid(y, gridHeight)) continue;
                
                for (Battler battler : grid[x][y]) {
                    if (battler.getType() != type) continue;
                    if (battler == sourceBattler) continue;
                    
                    int sqrDistance = sqrDistance(battler, sourceBattler);
                    
                    if (sqrDistance <= radius * radius) {
                        battlers.add(battler);
                    }
                }
            }
        }
        
        return battlers;
    }
    
    private int sqrDistance(Battler battler1, Battler battler2) {
        int xDif = Math.abs(battler1.getX() - battler2.getX());
        int yDif = Math.abs(battler1.getY() - battler2.getY());
        return xDif * xDif + yDif * yDif;
    }
    
    //checks if a grid coordinate is within the world bounds
    private Boolean isOnGrid(int gridCoord, int gridSize) {
        return gridCoord >= 0 && gridCoord < gridSize;
    }
    
    //converts a world position to a grid position
    private int worldToGrid(int worldCoord, int worldSize, int gridSize) {
        int cellSize = worldSize / gridSize;
        int gridCoord = worldCoord / cellSize;
        
        if (gridCoord < 0) gridCoord = 0;
        if (gridCoord >= gridSize) gridCoord = gridSize - 1;
        
        return gridCoord;
    }
    
    public void drawGridVisual() {
        world.getBackground().clear();
    }
}