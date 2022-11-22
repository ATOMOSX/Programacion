package co.edu.uniquindio.ingesis;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class ShapeTest {

    @Test
    void exercise() {
        List<Shape> list = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            switch (i%3){
                case 0: list.add(new Circle((float) (Math.random()*i))); break;
                case 1: list.add(new Square((float) (Math.random()*i))); break;
                case 2: list.add(new Triangle((float) (Math.random()*i), (float) (Math.random()*i))); break;
            }
        }

        for (Shape shape : list) {
            System.out.println(shape.computeArea());
        }

        System.out.println("solved...");

        // TODO put here your solution

    }
}