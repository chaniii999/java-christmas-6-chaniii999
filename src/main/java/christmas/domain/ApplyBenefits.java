package christmas.domain;

import christmas.model.OrderSheet;

public class ApplyBenefits {

    private final int MIN_APPLY_BENEFITS = 10000;

    private AllEvent allEvent;

    public ApplyBenefits(OrderSheet orderSheet, int date) {
        int totalAmount = orderSheet.getTotalAmount();
        if (isEventEnabled(totalAmount))
            allEvent = new AllEvent(orderSheet, date);
    }

    private boolean isEventEnabled(int totalAmount) {
        return (totalAmount >= MIN_APPLY_BENEFITS);
    }
    public AllEvent getAllEvent() {
        return allEvent;
    }

}
