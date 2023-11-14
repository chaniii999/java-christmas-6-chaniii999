package christmas.domain;

import christmas.OutputView.PrintBenefitsDetails;
import christmas.OutputView.PrintDecemberBadgeEvent;
import christmas.OutputView.PrintExpectPayment;
import christmas.OutputView.PrintGiveawayMenu;
import christmas.OutputView.PrintOrderSheet;
import christmas.OutputView.PrintPaymentBeforeDiscount;
import christmas.OutputView.PrintTotalBenefitAmount;
import christmas.model.Badge;
import christmas.model.Events.Event;
import christmas.model.OrderSheet;
import java.util.Collections;
import java.util.List;

public class PreviewBenefits {

    Badge badge;
    PrintOrderSheet printOrderSheet;
    PrintPaymentBeforeDiscount printPaymentBeforeDiscount;
    PrintGiveawayMenu printGiveawayMenu;
    PrintBenefitsDetails printBenefitsDetails;
    PrintTotalBenefitAmount printTotalBenefitAmount;
    PrintExpectPayment printExpectPayment;
    PrintDecemberBadgeEvent printDecemberBadgeEvent;

    public PreviewBenefits(OrderSheet orderSheet, AllEvent allEvent, int date) {
        List<Event> events = getAllEvent(allEvent);
        printOrderSheet = new PrintOrderSheet(orderSheet, date);
        printPaymentBeforeDiscount = new PrintPaymentBeforeDiscount(orderSheet);
        printGiveawayMenu = new PrintGiveawayMenu(events);
        printBenefitsDetails = new PrintBenefitsDetails(events);
        printTotalBenefitAmount = new PrintTotalBenefitAmount(getTotalBenefitAmount(allEvent));
        printExpectPayment = new PrintExpectPayment(getExpectPayment(orderSheet,allEvent));
        badge = new Badge(getTotalBenefitAmount(allEvent));
        printDecemberBadgeEvent = new PrintDecemberBadgeEvent(badge);
    }

    private List<Event> getAllEvent(AllEvent allEvent) {
        if (allEvent == null)
            return Collections.emptyList();
        return allEvent.getAllEvents();
    }

    private int getTotalBenefitAmount(AllEvent allEvent) {
        if (allEvent == null)
            return 0;
        return allEvent.getTotalDiscount();
    }

    private int getExpectPayment(OrderSheet orderSheet, AllEvent allEvent) {
        int result = orderSheet.getTotalAmount() + getTotalBenefitAmount(allEvent);
        if (orderSheet.getTotalAmount() >= 120000)
            result += 25000;
        return result;
    }
}
