package christmas.domain;

import christmas.InputView.OrderMenu;
import christmas.model.OrderSheet;

public class TakeOrder {

    private final OrderSheet orderSheet;

    public TakeOrder(AllMenu allMenu) {
        OrderMenu orderMenu = new OrderMenu(allMenu);
        orderSheet = new OrderSheet(orderMenu.getMenuItems());
    }

    public OrderSheet getOrderSheet() {
        return orderSheet;
    }
}
