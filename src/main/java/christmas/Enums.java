package christmas;

public enum Enums {
    YEAR(23),
    MONTH(12),
    START_DATE(1),
    END_DATE(31);

    private final int value;


    Enums(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
