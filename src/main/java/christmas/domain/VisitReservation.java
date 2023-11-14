package christmas.domain;

import christmas.InputView.VisitDate;


public class VisitReservation {

    private final int date;

    public VisitReservation() {
        VisitDate visitDate = new VisitDate();
        this.date = visitDate.getDate();
    }

    public int getVisitDate() {
        return date;
    }

}
