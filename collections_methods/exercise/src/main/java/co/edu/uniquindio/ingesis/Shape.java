package co.edu.uniquindio.ingesis;

public interface Shape extends Comparable<Shape>{
    float computeArea();

    /**
     * Define a default method in an interface
     *
     * @param other the object to be compared.
     * @return
     */
    @Override
    default int compareTo(Shape other) {
        return (int) (computeArea() - other.computeArea());
    }
}
