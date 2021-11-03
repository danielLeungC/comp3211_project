package src;

public class OtherSquare extends Square {
    public OtherSquare(SquareType squareType, String squareName) {
        super(squareType, squareName);
    }

    public String getSquareName() {
        return super.getSquareName();
    }

    public void setSquareName(String squareName) {
        super.setSquareName(squareName);
    }

    public SquareType getSquareType() {
        return super.getSquareType();
    }

    public void setSquareType(SquareType squareType) {
        super.setSquareType(squareType);
    }
}