package co.edu.uniquindio.ingesis;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

        list.sort(
                (shapeA,shapeB)->
                        (int) (shapeA.computeArea()-shapeB.computeArea())
        );

        List<Shape> listaOrdenada = list.stream().sorted(
                (shapeA,shapeB)->
                        (int) (shapeA.computeArea()-shapeB.computeArea())
        ).collect(Collectors.toList());

        // this line is equivalent to the for in the line 21
        list.forEach(shape -> System.out.println(shape.computeArea()));

        System.out.println("reordering...");

        list.sort(
                (shapeA,shapeB)->
                        (int) (-1 * (shapeA.computeArea() - shapeB.computeArea()))
        );

        // this line is equivalent to the for in the line 21
        list.forEach(shape -> System.out.println(shape.computeArea()));

    }
}