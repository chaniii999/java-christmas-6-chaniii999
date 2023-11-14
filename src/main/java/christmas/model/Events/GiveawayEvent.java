package christmas.model.Events;

import christmas.model.OrderSheet;

public class GiveawayEvent extends Event{
    private final int MIN_FREE = 120000;
    private final int sonDiscount = 25000;
    private final String sonApplyType = "샴페인";
    {
        initEventName = "증정 이벤트";
        applyType = sonApplyType;
        discount = sonDiscount;
    }


    @Override
    protected void applyBenefits(OrderSheet orderSheet, int date) {
        if (isMeetCondition(orderSheet, date)) {
            freeCondition = true;
            totalDiscount -= sonDiscount;
        }
    }

    private boolean isMeetCondition(OrderSheet orderSheet, int date) {
        return (orderSheet.getTotalAmount() >= MIN_FREE);
    }

    public GiveawayEvent(OrderSheet orderSheet, int date) {
        super(orderSheet, date);
    }

}
