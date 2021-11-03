package src;

public enum SquareType {
    PROPERTY (0),
    CHANCE (1),
    GO (2),
    TAX (3),
    PARKING (4),
    TOJAIL (5),
    JAIL (6)
    ;

    private final int typeInt;

    private SquareType(int typeInt) {
        this.typeInt = typeInt;
    }
}