package christmas;

public enum DateSettings {
    CURRENT_YEAR(2023),
    CURRENT_MONTH(12),
    START_DATE(1),
    END_DATE(31),
    CHRIST_MAS(25);

    private final int value;


    DateSettings(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
