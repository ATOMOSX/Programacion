package co.edu.uniquindio.ingesis;

public class Square implements Shape{
    private final float side;

    public Square(float side) {
        this.side = side;
    }

    @Override
    public float computeArea() {
        return side * side;
    }
}
