public class Rect {
    public Vector position;
    public Vector size;
    
    public Rect(Vector position, Vector size) {
        this.position = position;
        this.size = size;
    }
    
    public Vector getBottomLeft() {
        return Vector.subtract(position, Vector.divide(size, 2));
    }
}