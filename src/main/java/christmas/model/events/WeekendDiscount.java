package christmas.model.events;

import christmas.model.Menu;
import christmas.model.OrderSheet;
import java.util.ArrayList;
import java.util.List;

public class WeekendDiscount extends Event {

    private static final List<Integer> sonValidDays = new ArrayList<>(List.of(5, 6));
    private static final int sonDiscount = 2023;
    private static final String sonApplyType = "메인";
    {
        initEventName = "주말 할인";
        validDays = sonValidDays;
        applyType = sonApplyType;
        discount = sonDiscount;
    }

    @Override
    protected boolean validateDate(int date) {
        List<Integer> sonValidDays = new ArrayList<>(List.of(5, 6));
        int result = 0;
        int day = getDay(date);
        if (sonValidDays.contains(day))
            result++;
        if (startDate <= date && endDate >= date)
            result++;
        return (result == 2);
    }

    @Override
    protected void applyBenefits(OrderSheet orderSheet, int date) {
        for (Menu menu : orderSheet.getOrderSheet()) {
            if (sonApplyType.equals(menu.getType()))
                totalDiscount -= sonDiscount * menu.getCount();
        }
    }

    public WeekendDiscount(OrderSheet orderSheet,int date) {
        super(orderSheet, date);
    }

}
