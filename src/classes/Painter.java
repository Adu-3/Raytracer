package classes;
import java.io.IOException;

public class Painter {
    public static void main(String[] args) {
        Canvas canvas = new Canvas(256, 256);
        canvas.gradientFill();
        try {
            canvas.exportToPPM("gradient");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        spherePhoto();
    }

    public static void spherePhoto(){ // Filling canvas with book spheres example
        Camera camera = new Camera(0, 0, 0, 1, 1);
        Canvas canvas = new Canvas(256, 256);
        for (int x= -canvas.getWidth() / 2; x < (canvas.getWidth() / 2) ; x++){
            for (int y= -canvas.getHeight() / 2; y < (canvas.getHeight() / 2) ; y++){
                int D = CanvasToViewport(x, y);
                int color = TraceRay(O, D, 1, Double.POSITIVE_INFINITY);
    
            }
        }
    }

    public static void CanvasToViewport(int x, int y){

    }

    public static void CanvasToViewport(int x, int y) {
        return (x*Vw/Cw, y*Vh/Ch, d)
        }
}
