package christmas.OutputView;

import static christmas.OutputView.OutputViewMessage.FORM_MENU;
import static christmas.OutputView.OutputViewMessage.GIVEAWAY_MENU;
import static christmas.OutputView.OutputViewMessage.NO_BENEFIT;

import christmas.model.events.Event;
import java.util.List;

public class PrintGiveawayMenu {

    public PrintGiveawayMenu(List<Event> events) {
        System.out.println(GIVEAWAY_MENU.getForm());
        boolean benefits = false;

        if (!events.isEmpty()) {
            benefits = printGiveawayMenu(events);
            System.out.println();
        }

        if (!benefits) {
            System.out.println(NO_BENEFIT.getForm());
            System.out.println();
        }
    }

    private boolean printGiveawayMenu(List<Event> events) {
        for (Event event : events) {
            if (event.getFreeCondition()) {
                System.out.printf(FORM_MENU.getForm(), event.getApplyType(), event.getFreeCount());
                return true;
            }
        }
        return false;
    }
}
