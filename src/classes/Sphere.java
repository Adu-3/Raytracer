package classes;
import java.awt.Color;

public class Sphere {
    private Point3D center;
    private double radius;
    private Color color;
    
    public Sphere(Point3D center,double radius,Color color){
        this.center = center;
        this.radius = radius;
        this.color = color;
    }

    public Point3D getCenter(){
        return this.center;
    }

    public double getRadius(){
        return this.radius;
    }

    public Color getColor(){
        return this.color;
    }
}
