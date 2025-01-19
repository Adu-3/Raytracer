package classes;

public class Vector3D {
    private double x;
    private double y;
    private double z;

    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public Vector3D normalize() {
        double length = Math.sqrt(x * x + y * y + z * z);
        if (length == 0) {
            throw new ArithmeticException("Cannot normalize a zero-length vector");
        }
        return new Vector3D(x / length, y / length, z / length);
    }

    public double dot(Vector3D vector) {
        return this.x * vector.getX() + this.y * vector.getY() + this.z * vector.getZ();
    }

    public Vector3D cross(Vector3D vector) {
        return new Vector3D(
            this.y * vector.getZ() - this.z * vector.getY(),
            this.z * vector.getX() - this.x * vector.getZ(),
            this.x * vector.getY() - this.y * vector.getX()
        );
    }
}
