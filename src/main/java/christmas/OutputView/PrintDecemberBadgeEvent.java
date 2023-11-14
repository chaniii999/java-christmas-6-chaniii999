package christmas.OutputView;

import static christmas.OutputView.OutputViewMessage.EVENT_BADGE;

import christmas.model.Badge;

public class PrintDecemberBadgeEvent {
    public PrintDecemberBadgeEvent(Badge badge) {
        System.out.println(EVENT_BADGE.getForm());
        System.out.println(badge.getBadge());
    }
}
