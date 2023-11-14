package christmas.model.Events;

import christmas.model.OrderSheet;
import java.util.ArrayList;
import java.util.List;

public class SpecialDiscount extends Event {
    {
        initEventName = "특별 할인";
        validDays = new ArrayList<>(List.of(1));
        discount = 1000;
    }

    private final int  CHRISTMAX = 25;
    private final int copyDiscount = discount;


    @Override
    protected boolean validateDate(int date) {
        List<Integer> copyValidDays = new ArrayList<Integer>(validDays);
        int result = 0;
        int day = getDay(date);
        if (copyValidDays.contains(day) || date == CHRISTMAX)
            result++;
        if (startDate <= date && endDate >= date)
            result++;
        return (result == 2);
    }

    @Override
    protected void applyBenefits(OrderSheet orderSheet, int date) {
        totalDiscount -= copyDiscount;
    }

    public SpecialDiscount(OrderSheet orderSheet,int date) {
        super(orderSheet,date);
    }

}
