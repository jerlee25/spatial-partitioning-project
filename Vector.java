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
    
        public static Vector subtract(Vector v1, Vector v2){
        return new Vector(v1.x - v2.x, v1.y - v2.y);
    }
}