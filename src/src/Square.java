package src;

public class Square {
    private String squareName;
    private SquareType squareType;

    public Square(SquareType squareType, String squareName) {
        this.squareType = squareType;
        this.squareName = squareName;
    }

    public String getSquareName() {
        return squareName;
    }

    public void setSquareName(String squareName) {
        this.squareName = squareName;
    }

    public SquareType getSquareType() {
        return squareType;
    }

    public void setSquareType(SquareType squareType) {
        this.squareType = squareType;
    }
}
