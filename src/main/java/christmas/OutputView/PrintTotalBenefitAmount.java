package christmas.OutputView;

import static christmas.OutputView.OutputViewMessage.FORM_PAYMENT;
import static christmas.OutputView.OutputViewMessage.TOTAL_BENEFITS;

public class PrintTotalBenefitAmount {

    public PrintTotalBenefitAmount(int totalBenefitAmount) {
        System.out.println(TOTAL_BENEFITS.getForm());
        System.out.printf(FORM_PAYMENT.getForm(),totalBenefitAmount);
        System.out.println();
    }

}
