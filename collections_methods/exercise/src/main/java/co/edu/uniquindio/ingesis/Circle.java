package co.edu.uniquindio.ingesis;

public class Circle implements Shape{
    private final float radius;

    public Circle(float radius) {
        this.radius = radius;
    }

    @Override
    public float computeArea() {
        return (float) (Math.PI * radius * radius);
    }
}
