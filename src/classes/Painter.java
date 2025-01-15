package classes;
import java.io.IOException;

public class Painter {
    public static void main(String[] args) {
        Canvas canvas = new Canvas(256, 256);
        gradientFill(canvas);
        try {
            canvas.exportToPPM("gradient");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        canvas = new Canvas(1024, 1024);
    }

    public static void gradientFill(Canvas canvas) { // Fill with raytracing in one weekend first example
        int height = canvas.getHeight();
        int width = canvas.getWidth();
        for (double fillHeight = 0 ; fillHeight < height ; fillHeight++){
            for (double fillWidth = 0;  fillWidth < width ; fillWidth++){
                double r = fillWidth / (width - 1);
                double g = fillHeight / (height - 1);
                int ir = (int) Math.round(255.99 * r);
                int ig = (int) Math.round(255.99 * g);
                canvas.putPixel((int) fillHeight, (int) fillWidth, ir, ig, 0);
            }
        }
    }

    public static void sphereFill(Canvas canvas){ // Filling canvas with book spheres example
        
    }
}
