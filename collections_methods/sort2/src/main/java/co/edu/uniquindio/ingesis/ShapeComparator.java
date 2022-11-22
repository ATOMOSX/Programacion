package co.edu.uniquindio.ingesis;

import java.util.Comparator;

public class ShapeComparator implements Comparator<Shape> {
    @Override
    public int compare(Shape shapeA, Shape shapeB) {
        return (int) (shapeA.computeArea() - shapeB.computeArea());
    }
}
