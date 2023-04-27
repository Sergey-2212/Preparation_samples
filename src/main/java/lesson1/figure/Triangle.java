package lesson1.figure;

public class Triangle implements Figure {

    private float side1;
    private float side2;
    private float side3;
    private String colour;


    public Triangle(float side1, float side2, float side3, String colour) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        this.colour = colour;
    }


    @Override
    public float volume() {
        float p = (side1 + side2 + side3) / 2;

        return (float) (Math.sqrt(p*(p - side1) * (p - side2) * (p - side3)));
    }

    @Override
    public float perimeter() {
        return  side1 + side2 + side3;
    }

    @Override
    public String getColour() {
        return null;
    }
}
