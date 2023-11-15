package christmas.model.Events;

import christmas.model.OrderSheet;
import java.util.ArrayList;
import java.util.List;

public class SpecialDiscount extends Event {

    private final List<Integer> sonValidDays = new ArrayList<>(List.of(7));
    private final int sonDiscount = 1000;
    {
        initEventName = "특별 할인";
        validDays = sonValidDays;
        discount = sonDiscount;
    }

    @Override
    protected boolean validateDate(int date) {
        List<Integer> sonValidDays = new ArrayList<>(List.of(7));
        int result = 0;
        int day = getDay(date);
        if (date == X_MAS || sonValidDays.contains(day))
            result++;
        if (startDate <= date && endDate >= date)
            result++;
        return (result == 2);
    }

    @Override
    protected void applyBenefits(OrderSheet orderSheet, int date) {
        totalDiscount -= sonDiscount;
    }

    public SpecialDiscount(OrderSheet orderSheet,int date) {
        super(orderSheet,date);
    }

}
