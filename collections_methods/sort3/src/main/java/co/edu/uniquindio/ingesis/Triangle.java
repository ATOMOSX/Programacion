package co.edu.uniquindio.ingesis;

public class Triangle implements Shape{
    private final float base;
    private final float height;

    public Triangle(float base, float height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public float computeArea() {
        return base * height /2;
    }
}
