package lesson1.figure;

public class Circle implements Figure {

    private float radius;
    private String colour;

    public Circle(float radius, String colour) {
        this.radius = radius;
        this.colour = colour;
    }

    @Override
    public float volume() {
        return (float) Math.pow(Math.PI * radius, 2) / 2;
    }

    @Override
    public float perimeter() {
        return (float) (2 * Math.PI * radius);
    }

    @Override
    public String getColour() {
        return colour;
    }
}
