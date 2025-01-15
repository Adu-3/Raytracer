package classes;
import java.io.FileWriter;
import java.io.IOException;

public class Canvas {
    private int height;
    private int width;
    private int image[][][]; // 3 dimension to be able to store colors in RGB format

    public Canvas(int height ,int  width){
        this.width = width;
        this.height = height;
        image = new int [height][width][3];
    }

    public int getHeight(){
        return height;
    }

    public int getWidth(){
        return width;
    }

    public void fill() { // Fill with raytracing in one weekend first example
        for (double fillHeight = 0 ; fillHeight < height ; fillHeight++){
            for (double fillWidth = 0;  fillWidth < width ; fillWidth++){
                double r = fillWidth / (width - 1);
                double g = fillHeight / (height - 1);
                int ir = (int) Math.round(255.99 * r);
                int ig = (int) Math.round(255.99 * g);
                image[(int) fillHeight][(int) fillWidth][0] = ir;
                image[(int) fillHeight][ (int) fillWidth][1] = ig;
                image[ (int) fillHeight][(int) fillWidth][2] = 0; // Represent blue and will be 0 in this picture
            }
        }
    }

    public void exportToPPM(String imageName) throws IOException{ 
        FileWriter writer = new FileWriter("src/output/" + imageName + ".ppm");
        writer.append("P3\n" + width +" "+ height + "\n255\n") ; // write the file header
        for(int fillHeight = 0 ; fillHeight < height ; fillHeight++){
            for(int fillWidth = 0;  fillWidth < width ; fillWidth++){
                int ir = image[fillHeight][fillWidth][0];
                int ig = image[fillHeight][fillWidth][1];
                int ib = image[fillHeight][fillWidth][2];
                writer.append(ir + " " +  ig +" " + ib + "\n");
            }
        }
        writer.close();
    }

    public void putPixel(int height, int width ,int r,int g , int b){
        image[height][width][0] = r;
        image[height][width][1] = g;
        image[height][width][2] = b;
    }

}
