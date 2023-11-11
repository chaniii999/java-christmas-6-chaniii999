package christmas.domain;

import christmas.InputView.VisitDate;

public class VisitReservation {
    VisitDate visitDate;

    private final int date;

    public VisitReservation() {
        visitDate = new VisitDate();
        date = visitDate.getDate();
    }

}
