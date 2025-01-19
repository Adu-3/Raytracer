package classes;
import java.awt.Color;
import java.util.ArrayList;

public class Scene {
    private Camera SceneCamera;
    private ArrayList<Sphere> objects;
    final private Color BACKGROUND_COLOR = new Color(255,255,255); // White as default color

    public Scene(){
        Point3D cameraCordinate = new Point3D(0, 0, 0);
        this.SceneCamera = new Camera(cameraCordinate,1, 1);
        objects = new ArrayList<>();
    }

    public boolean addToScene(Sphere object){
        return objects.add(object);
    }

    public void renderScene(Canvas canvas){ 
        for (int x= -canvas.getWidth() / 2; x < (canvas.getWidth() / 2) ; x++){
            for (int y= -canvas.getHeight() / 2; y < (canvas.getHeight() / 2) ; y++){
                Vector3D D = canvasToViewport(x ,y ,canvas.getHeight() ,canvas.getWidth());
                Color color = traceRay(SceneCamera.getCordinate(), D, 1, Double.POSITIVE_INFINITY);
                canvas.putPixel(x, y, color);
            }
        }
    }

    private  Vector3D canvasToViewport(int x ,int y ,int height ,int width ) {
        return new Vector3D(
            x * SceneCamera.getViewWidth() / width,
            y * SceneCamera.getViewHeight() / height,
            1
        );
    }
    
    private Color traceRay(Point3D O, Vector3D D, double t_min, double t_max) {
        double closest_t = Double.POSITIVE_INFINITY;
        Sphere closest_sphere = null;
    
        for (Sphere sphere : objects) {
            double[] t = intersectRaySphere(O, D, sphere);
            double t1 = t[0];
            double t2 = t[1];
    
            if (t1 >= t_min && t1 <= t_max && t1 < closest_t) {
                closest_t = t1;
                closest_sphere = sphere;
            }
            if (t2 >= t_min && t2 <= t_max && t2 < closest_t) {
                closest_t = t2;
                closest_sphere = sphere;
            }
        }
    
        // If no sphere is hit, return background color
        if (closest_sphere == null) {
            return BACKGROUND_COLOR;
        }
    
        // Return the color of the closest sphere
        return closest_sphere.getColor();
    }
    

    private double[] intersectRaySphere(Point3D O, Vector3D D, Sphere sphere) {
        Point3D center = sphere.getCenter();
        double radius = sphere.getRadius();
    
        Vector3D CO = O.subtract(center);
    
        double a = D.dot(D);
        double b = 2 * CO.dot(D);
        double c = CO.dot(CO) - radius * radius;
    
        double discriminant = b * b - 4 * a * c;
    
        if (discriminant < 0) {
            return new double[]{Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY};
        }
    
        double t1 = (-b + Math.sqrt(discriminant)) / (2 * a);
        double t2 = (-b - Math.sqrt(discriminant)) / (2 * a);
    
        return new double[]{t1, t2};
    }
    
}