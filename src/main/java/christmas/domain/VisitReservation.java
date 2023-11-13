package christmas.domain;

import christmas.InputView.VisitDate;


public class VisitReservation {

    private final VisitDate visitDate;
    private final int date;

    public VisitReservation() {
        visitDate = new VisitDate();
        date = visitDate.getDate();
    }

    public int getVisitDate() {
        return date;
    }

}
