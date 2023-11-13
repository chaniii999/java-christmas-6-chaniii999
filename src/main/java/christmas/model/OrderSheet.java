package christmas.model;

import java.util.ArrayList;

public class OrderSheet {

    private final ArrayList<Menu> orderSheet = new ArrayList<Menu>();

    public OrderSheet(String[] orderMenu) {
        validateOrderMenu(orderMenu);
    }

    private void validateOrderMenu(String[] orderMenu) {

    }
}
