package classes;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.Color;

public class Canvas {
    private int height;
    private int width;
    private Color image[][];

    public Canvas(int height ,int  width){
        this.width = width;
        this.height = height;
        image = new Color [height][width];
    }

    public int getHeight(){
        return height;
    }

    public int getWidth(){
        return width;
    }

    public void gradientFill() { // Fill with raytracing in one weekend first example
        for (double fillHeight = 0 ; fillHeight < height ; fillHeight++){
            for (double fillWidth = 0;  fillWidth < width ; fillWidth++){
                double r = fillWidth / (width - 1);
                double g = fillHeight / (height - 1);
                int ir = (int) Math.round(255.99 * r);
                int ig = (int) Math.round(255.99 * g);
                Color color = new Color(ir,ig,0);
                image[(int) fillHeight][(int) fillWidth] = color;
                }
        }
    }

    public void exportToPPM(String imageName) throws IOException{ 
        FileWriter writer = new FileWriter("src/output/" + imageName + ".ppm");
        writer.append("P3\n" + width +" "+ height + "\n255\n") ; // write the file header
        for(int fillHeight = 0 ; fillHeight < height ; fillHeight++){
            for(int fillWidth = 0;  fillWidth < width ; fillWidth++){
                Color color = image[fillHeight][fillWidth];
                writer.append(color.getRed() + " " +  color.getGreen() +" " + color.getBlue() + "\n");
            }
        }
        writer.close();
    }

    public boolean putPixel(int x, int y ,Color color){
        int x_cord = width/2 + x;
        int y_cord = height/2 + y;
        image[y_cord][x_cord] = color;
        return true;
    }

    // public void CanvasToViewport(x, y) {
    //     return (x*Vw/Cw, y*Vh/Ch, d)
    // }

}
