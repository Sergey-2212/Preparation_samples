package lesson1.figure;

public class Square implements Figure{

    private float side;
    private String colour;

    public Square(float side, String colour) {
        this.side = side;
        this.colour = colour;
    }

    @Override
    public float volume() {
        return side * side;
    }

    @Override
    public float perimeter() {
        return side * 4;
    }

    public float getSide() {
        return side;
    }

    public void setSide(float side) {
        this.side = side;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }
}
