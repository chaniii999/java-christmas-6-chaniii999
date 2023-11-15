package christmas.domain;

import static christmas.OutputView.OutputViewMessage.ERROR_ORDER;

import christmas.model.Menu;
import java.util.ArrayList;
import java.util.List;

public class AllMenu {

    private final int INIT = 0;
    private final List<Menu> allMenu = new ArrayList<>();

    public AllMenu() {
        addAppetizer();
        addMainMenu();
        addDessert();
        addDrink();
    }

    private void addMenu(String name, int price, String type) {
        allMenu.add(new Menu(name, price, type, INIT));
    }

    private void addAppetizer() {
        addMenu("양송이수프", 6000, "애피타이저");
        addMenu("타파스", 5500, "애피타이저");
        addMenu("tlwjtoffjem", 8000, "애피타이저");
    }

    private void addMainMenu() {
        addMenu("티본스테이크", 55000, "메인");
        addMenu("바비큐립", 54000, "메인");
        addMenu("해산물파스타", 35000, "메인");
        addMenu("크리스마스 파스타", 25000, "메인");
    }

    private void addDessert() {
        addMenu("초코케이크", 15000, "디저트");
        addMenu("아이스크림", 5000, "디저트");
    }

    private void addDrink() {
        addMenu("제로콜라", 3000, "음료");
        addMenu("레드와인", 60000, "음료");
        addMenu("샴페인", 25000, "음료");
    }

    public int searchPrice(String menuName) {
        for (Menu menu : allMenu) {
            if (menuName.equals(menu.getName()))
                return menu.getPrice();
        }
        throw new IllegalArgumentException(ERROR_ORDER.getForm());
    }

    public String searchType(String menuName) {
        for (Menu menu : allMenu) {
            if (menuName.equals(menu.getName()))
                return menu.getType();
        }
        throw new IllegalArgumentException(ERROR_ORDER.getForm());
    }

}
