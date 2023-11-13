package christmas.controller;

import christmas.domain.TakeOrder;
import christmas.domain.VisitReservation;
import christmas.model.Menu;
import christmas.service.AllMenu;
import java.util.List;

public class EventPlanner {

    VisitReservation visitReservation;
    AllMenu allMenu;
    TakeOrder takeOrder;

    public void takeOrder() {
        visitReservation = new VisitReservation();
        allMenu = new AllMenu();
        takeOrder = new TakeOrder(allMenu);
        List<Menu> orderSheet = takeOrder.getOrderSheet();
    }
}
