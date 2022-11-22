package co.edu.uniquindio.ingesis;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class ShapeTest {

    @Test
    void sort() {
        List<Shape> list = new ArrayList<>();

        list.add(new Circle(3f));
        list.add(new Square(3f));
        list.add(new Triangle(3f, 2f));

        for (Shape shape : list) {
            System.out.println(shape.computeArea());
        }

        System.out.println("ordering...");

        list.sort(ShapeComparator::compare);

        // this line is equivalent to the for in the line 21
        list.forEach(shape -> System.out.println(shape.computeArea()));

        System.out.println("reordering...");

        list.sort(ShapeComparator::inverseOrder);

        // this line is equivalent to the for in the line 21
        list.forEach(shape -> System.out.println(shape.computeArea()));

    }
}