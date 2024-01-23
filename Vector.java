public class Vector {
    public int x;
    public int y;
    
    public Vector(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public static Vector divide(Vector v, int f){
        return new Vector(v.x / f, v.y / f);
    }
}