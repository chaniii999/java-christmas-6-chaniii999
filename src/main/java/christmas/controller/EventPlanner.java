package christmas.controller;

import christmas.domain.ApplyBenefits;
import christmas.domain.PreviewBenefits;
import christmas.domain.TakeOrder;
import christmas.domain.VisitReservation;
import christmas.model.OrderSheet;
import christmas.domain.AllMenu;

public class EventPlanner {

    private final AllMenu allMenu;
    private final VisitReservation visitReservation;
    private final TakeOrder takeOrder;
    private final OrderSheet orderSheet;
    private final ApplyBenefits applyBenefits;
    private final PreviewBenefits previewBenefits;

    public EventPlanner() {
        allMenu = new AllMenu();
        visitReservation = new VisitReservation();
        int date = visitReservation.getVisitDate();
        takeOrder = new TakeOrder(allMenu);
        orderSheet = takeOrder.getOrderSheet();
        applyBenefits = new ApplyBenefits(orderSheet, date);
        previewBenefits = new PreviewBenefits(orderSheet, applyBenefits.getAllEvent(), date);
    }

}
