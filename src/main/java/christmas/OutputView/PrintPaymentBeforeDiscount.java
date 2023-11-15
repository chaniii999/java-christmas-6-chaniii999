package christmas.OutputView;

import static christmas.OutputView.OutputViewMessage.FORM_PAYMENT;
import static christmas.OutputView.OutputViewMessage.PAYMENT_BEFORE_DISCOUNT;

import christmas.model.OrderSheet;

public class PrintPaymentBeforeDiscount {

    public PrintPaymentBeforeDiscount(OrderSheet orderSheet) {
        int totalAmount = orderSheet.getTotalAmount();

        System.out.println(PAYMENT_BEFORE_DISCOUNT.getForm());
        System.out.printf(FORM_PAYMENT.getForm(), totalAmount);
        System.out.println();
    }
}
