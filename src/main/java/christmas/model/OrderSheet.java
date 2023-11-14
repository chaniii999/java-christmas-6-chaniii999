package christmas.model;

import christmas.domain.AllMenu;
import java.util.ArrayList;
import java.util.List;

public class OrderSheet extends AllMenu {

    private final String MENU_SEPARATOR = "-";

    private final List<Menu> orderSheet = new ArrayList<>();
    private int totalAmount = 0;

    public OrderSheet(String[] orderMenu, AllMenu allmenu) {
        generateOrderSheet(orderMenu, allmenu);
    }

    private void generateOrderSheet(String[] orderMenu, AllMenu menu) {
        for (String order : orderMenu) {
            String menuName = order.split(MENU_SEPARATOR)[0];
            int count = Integer.parseInt(order.split(MENU_SEPARATOR)[1]);
            totalAmount += searchPrice(menuName) * count;

            orderSheet.add(new Menu(menuName, searchPrice(menuName), searchType(menuName), count));
        }
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public List<Menu> getOrderSheet() {
        return orderSheet;
    }

}
