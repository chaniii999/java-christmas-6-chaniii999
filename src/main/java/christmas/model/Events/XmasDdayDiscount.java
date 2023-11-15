package christmas.model.Events;

import static christmas.DateSettings.CHRIST_MAS;

import christmas.model.OrderSheet;

public class XmasDdayDiscount extends Event{
    private final int sonDiscount = 900;
    private final int sonEndDate = CHRIST_MAS.getValue();
    {
        initEventName = "크리스마스 디데이 할인";
        discount = sonDiscount;
        endDate = sonEndDate;
    }

    @Override
    protected boolean validateDate(int date) {
        int result = 0;
        int day = getDay(date);

        if (validDays.contains(day) || validDays.isEmpty())
            result++;
        if (startDate <= date && CHRIST_MAS.getValue() >= date)
            result++;
        return (result == 2);
    }

    @Override
    protected void applyBenefits(OrderSheet orderSheet, int date) {
        totalDiscount -= sonDiscount + date * 100;
    }

    public XmasDdayDiscount(OrderSheet orderSheet, int date) {
        super(orderSheet, date);
    }

}
