package christmas.model.Events;

import static christmas.DateSettings.CHRIST_MAS;

import christmas.model.OrderSheet;
import java.util.ArrayList;
import java.util.List;

public class SpecialDiscount extends Event {

    private final List<Integer> copyValiddays = new ArrayList<>(List.of(1));
    private final int CHRISTMAS = CHRIST_MAS.getValue();
    private final int copyDiscount = 1000;
    {
        initEventName = "특별 할인";
        validDays = copyValiddays;
        discount = copyDiscount;
    }

    @Override
    protected boolean validateDate(int date) {
        List<Integer> copyValidDays = new ArrayList<>(validDays);
        int result = 0;
        int day = getDay(date);
        if (copyValidDays.contains(day) || date == CHRISTMAS)
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
