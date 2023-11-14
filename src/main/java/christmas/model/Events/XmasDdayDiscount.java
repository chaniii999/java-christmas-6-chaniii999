package christmas.model.Events;

import christmas.model.OrderSheet;

public class XmasDdayDiscount extends Event{
    private final int DISCOUNT = 900;
    private final int  CHRISTMAX = 25;

    {
        initEventName = "크리스마스 디데이 할인";
        discount = DISCOUNT;
        endDate = CHRISTMAX;
    }

    @Override
    protected boolean validateDate(int date) {
        int result = 0;
        int day = getDay(date);
        if (validDays.contains(day) || validDays.isEmpty())
            result++;
        if (startDate <= date && CHRISTMAX >= date)
            result++;
        return (result == 2);
    }

    @Override
    protected void applyBenefits(OrderSheet orderSheet,int date) {
        totalDiscount -= DISCOUNT + date * 100;
    }

    public XmasDdayDiscount(OrderSheet orderSheet,int date) {
        super(orderSheet, date);
    }

}
