package co.edu.uniquindio.ingesis;

public class ShapeComparator {
    public static  int compare(Shape shapeA, Shape shapeB) {
        return (int) (shapeA.computeArea() - shapeB.computeArea());
    }

    public static  int inverseOrder(Shape shapeA, Shape shapeB) {
        return -1 * compare(shapeA,shapeB);
    }
}
