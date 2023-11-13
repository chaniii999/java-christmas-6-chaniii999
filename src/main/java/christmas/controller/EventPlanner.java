package christmas.controller;

import christmas.InputView.OrderMenu;
import christmas.domain.VisitReservation;
import christmas.service.AllMenu;

public class EventPlanner {

    VisitReservation visitReservation;
    AllMenu allMenu;
    OrderMenu orderMenu;

    public void takeOrder() {
        visitReservation = new VisitReservation();

        allMenu = new AllMenu();
        orderMenu = new OrderMenu(allMenu);
    }
}
