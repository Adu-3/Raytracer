package classes;
import java.awt.Color;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        gradientFillPhoto(); 
        spherePhoto();
    }

    public static void spherePhoto(){  
        // Filling canvas with book spheres example
        Scene spherScene = new Scene();
        Canvas canvas = new Canvas(256,256); // Setup the picture 
        // 1st Sphere
        Point3D center = new Point3D(0, -1, 3);
        Color color = new Color(255,0,0);
        spherScene.addToScene(new Sphere(center, 1,color )); 
        // 2nd Sphere
        center = new Point3D(2, 0, 4);
        color = new Color(0,0,255);
        spherScene.addToScene(new Sphere(center, 1,color )); 
        // 3rd Sphere
        center = new Point3D(-2, 0, 4);
        color = new Color(0,255,0);
        spherScene.addToScene(new Sphere(center, 1,color )); 
        // Rendering
        spherScene.renderScene(canvas);
        try {
            canvas.exportToPPM("Spheres");  // Save image
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void gradientFillPhoto(){
        Canvas canvas = new Canvas(256, 256);
        canvas.gradientFill();
        try {
            canvas.exportToPPM("Gradient");
        } 
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}