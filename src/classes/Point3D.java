package classes;

public class Point3D {
    private double x;
    private double y;
    private double z;

    public Point3D(double x ,double y ,double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    public double getZ(){
        return z;
    }

    // Add a vector to the point (point + vector)
    public Point3D add(Vector3D vector) {
        return new Point3D(this.x + vector.getX(), this.y + vector.getY(), this.z + vector.getZ());
    }

    // Subtract a vector from the point (point - vector)
    public Point3D subtract(Vector3D vector) {
        return new Point3D(this.x - vector.getX(), this.y - vector.getY(), this.z - vector.getZ());
    }

    // Get the vector difference between two points (point - point = vector)
    public Vector3D subtract(Point3D point) {
        return new Vector3D(this.x - point.getX(), this.y - point.getY(), this.z - point.getZ());
    }

}
