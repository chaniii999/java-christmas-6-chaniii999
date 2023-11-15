package christmas.OutputView;

import static christmas.OutputView.OutputViewMessage.BENEFITS;
import static christmas.OutputView.OutputViewMessage.FORM_BENEFIT;
import static christmas.OutputView.OutputViewMessage.NO_BENEFIT;

import christmas.model.events.Event;
import java.util.List;

public class PrintBenefitsDetails {

    public PrintBenefitsDetails(List<Event> events) {
        System.out.println(BENEFITS.getForm());
        boolean benefits = false;

        if (!events.isEmpty())
            benefits = printBenefitsDetails(events);

        if (!benefits)
            System.out.println(NO_BENEFIT.getForm());

        System.out.println();
    }

    private boolean printBenefitsDetails(List<Event> events) {
        boolean benefit = false;

        for (Event event : events) {
            if (event.getTotalDiscount() != 0) {
                String eventName = event.getEventName();
                int totalDiscount = event.getTotalDiscount();

                printBenefit(eventName, totalDiscount);
                benefit = true;
            }
        }
        return benefit;
    }

    private void printBenefit(String eventName, int totalDiscount) {
        System.out.printf(FORM_BENEFIT.getForm(), eventName, totalDiscount);
    }

}
