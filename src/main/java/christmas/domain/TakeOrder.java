package christmas.domain;


import christmas.InputView.OrderMenu;
import christmas.model.Menu;
import christmas.model.OrderSheet;
import christmas.service.AllMenu;
import java.util.List;

public class TakeOrder {


    private final List<Menu> orderItems;

    public TakeOrder(AllMenu allMenu) {
        OrderMenu orderMenu = new OrderMenu(allMenu);
        OrderSheet orderSheet = new OrderSheet(orderMenu.getMenuItems(), allMenu);
        orderItems = orderSheet.getOrderSheet();
    }

    public List<Menu> getOrderSheet() {
        return orderItems;
    }

}
