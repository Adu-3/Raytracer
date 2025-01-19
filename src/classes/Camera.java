package classes;

public class Camera {
    // Viewport config
    private int viewHeight;
    private int ViewWidth;
    // Position
    private Point3D cordinate;

    public Camera(Point3D cordinate ,int viewHeight,int ViewWidth){
        this.cordinate = cordinate;
        this.viewHeight = viewHeight;
        this.ViewWidth = ViewWidth;
    }
    
    public int getViewHeight(){
        return viewHeight;
    }

    public int getViewWidth(){
        return ViewWidth;
    }

    public Point3D getCordinate(){
        return cordinate;
    }
}
