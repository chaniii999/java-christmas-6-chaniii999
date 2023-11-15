package christmas.domain;

import christmas.model.events.Event;
import christmas.model.OrderSheet;
import christmas.model.events.GiveawayEvent;
import christmas.model.events.SpecialDiscount;
import christmas.model.events.WeekdayDiscount;
import christmas.model.events.WeekendDiscount;
import christmas.model.events.XmasDdayDiscount;
import java.util.ArrayList;
import java.util.List;

public class AllEvent {

    private final List<Event> allEvent = new ArrayList<>();
    private int totalDiscount = 0;

    public AllEvent(OrderSheet orderSheet, int date) {
        applyEvents(new XmasDdayDiscount(orderSheet, date));
        applyEvents(new WeekdayDiscount(orderSheet, date));
        applyEvents(new WeekendDiscount(orderSheet, date));
        applyEvents(new SpecialDiscount(orderSheet, date));
        applyEvents(new GiveawayEvent(orderSheet, date));
    }

    private void applyEvents(Event event) {
        allEvent.add(event);
        totalDiscount += event.getTotalDiscount();
    }

    public List<Event> getAllEvents() {
        return allEvent;
    }

    public int getTotalDiscount() {
        return totalDiscount;
    }

}
