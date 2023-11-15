package christmas.OutputView;

import static christmas.OutputView.OutputViewMessage.FORM_PAYMENT;
import static christmas.OutputView.OutputViewMessage.PAYMENT_EXPECT;

public class PrintExpectPayment {

    public PrintExpectPayment(int expectPayment) {
        System.out.println(PAYMENT_EXPECT.getForm());
        System.out.printf(FORM_PAYMENT.getForm(), expectPayment);
        System.out.println();
    }

}
