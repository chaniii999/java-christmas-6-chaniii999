package christmas.model.events;

import static christmas.DateSettings.CHRIST_MAS;
import static christmas.DateSettings.CURRENT_MONTH;
import static christmas.DateSettings.CURRENT_YEAR;
import static christmas.DateSettings.END_DATE;
import static christmas.DateSettings.START_DATE;

import christmas.model.Menu;
import christmas.model.OrderSheet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Event {

    protected final int YEAR = CURRENT_YEAR.getValue();
    protected final int MONTH = CURRENT_MONTH.getValue();
    protected final int X_MAS = CHRIST_MAS.getValue();

    protected String initEventName = "이벤트 이름";

    protected int startDate = START_DATE.getValue();
    protected int endDate = END_DATE.getValue();

    protected List<Integer> validDays = new ArrayList<>();

    protected int discount = 0;
    protected int totalDiscount = 0;

    protected String applyType = "";

    protected boolean freeCondition = false;
    protected int freeCount = 1;

    public Event(OrderSheet orderSheet, int date) {
        if (validateDate(date))
            applyBenefits(orderSheet, date);
    }

    protected boolean validateDate(int date) {
        int result = 0;
        int day = getDay(date);
        if (validDays.contains(day) || validDays.isEmpty())
            result++;
        if (startDate <= date && endDate >= date)
            result++;
        return (result == 2);
    }

    protected void applyBenefits(OrderSheet orderSheet, int date) {
        for (Menu menu : orderSheet.getOrderSheet()) {
            if (applyType.equals(menu.getType()))
                totalDiscount -= discount * menu.getCount();
        }
    }

    protected int getDay(int date) {
        LocalDate localDate = LocalDate.of(YEAR, MONTH, date);
        return localDate.getDayOfWeek().getValue();
    }

    public String getEventName() {
        return initEventName;
    }

    public int getTotalDiscount() {
        return totalDiscount;
    }

    public boolean getFreeCondition() {
        return freeCondition;
    }

    public String getApplyType() {
        return applyType;
    }

    public int getFreeCount() {
        return freeCount;
    }

}
