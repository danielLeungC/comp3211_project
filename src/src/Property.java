package src;

public class Property extends Square {
    private int price;
    private int rent;
    private boolean owned;
    private String owner;

    public Property(SquareType squareType, String squareName, int price, int rent) {
        super(squareType, squareName);
        this.price = price;
        this.rent = rent;
        this.owned = false;
        this.owner = null;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
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

    public boolean isOwned() {
        return owned;
    }

    public void setOwned(boolean owned) {
        this.owned = owned;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
