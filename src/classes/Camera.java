package classes;

public class Camera {
    // Viewport config
    private int viewHeight;
    private int ViewWidth;
    // Position
    private int x;
    private int y;
    private int z;

    public Camera(int x,int y,int z,int viewHeight,int ViewWidth){
        this.x = x;
        this.y = y;
        this.z = z;
        this.viewHeight = viewHeight;
        this.ViewWidth = ViewWidth;
    }
    
    public int getViewHeight(){
        return viewHeight;
    }

    public int getViewWidth(){
        return ViewWidth;
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public int getZ(){
        return z;
    }
}
