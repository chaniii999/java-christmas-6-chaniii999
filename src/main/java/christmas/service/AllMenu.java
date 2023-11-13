package christmas.service;

import static christmas.OutputView.OutputViewMessage.ERROR_ORDER;

import christmas.model.Menu;
import java.util.ArrayList;
import java.util.List;

public class AllMenu {

    private final List<Menu> allMenu;

    private final List<String> menuName = new ArrayList<>();
    private final List<Integer> menuPrice = new ArrayList<>();
    private final List<String> foodType = new ArrayList<>();

    public AllMenu() {
        addMenu("양송이수프", 6000, "애피타이저");
        addMenu("타파스", 5500, "애피타이저");
        addMenu("tlwjtoffjem", 8000, "애피타이저");

        addMenu("티본스테이크", 55000, "메인");
        addMenu("바비큐립", 54000, "메인");
        addMenu("해산물파스타", 35000, "메인");
        addMenu("크리스마스 파스타", 25000, "메인");

        addMenu("초코케이크", 15000, "디저트");
        addMenu("아이스크림", 5000, "디저트");

        addMenu("제로콜라", 3000, "음료");
        addMenu("레드와인", 60000, "음료");
        addMenu("샴페인", 25000, "음료");

        this.allMenu = createAllMenu(menuName, menuPrice, foodType);
    }


    private void addMenu(String name, int price, String type) {
        this.menuName.add(name);
        this.menuPrice.add(price);
        this.foodType.add(type);
    }

    private List<Menu> createAllMenu(List<String> name, List<Integer> price, List<String> type) {
        List<Menu> allMenu = new ArrayList<>();

        for (int i = 0; i < name.size(); i++) {
            Menu menu = new Menu(name.get(i), price.get(i), type.get(i), 0);
            allMenu.add(menu);
        }
        return allMenu;
    }

    public List<Menu> getAllMenu() {
        return this.allMenu;
    }

    public int searchPrice(String name) {
        for (Menu menu : allMenu) {
            if (name.equals(menu.getName())) {
                return menu.getPrice();
            }
        }
        throw new IllegalArgumentException();
    }

    public String searchType(String name) {
        for (Menu menu : allMenu) {
            if (name.equals(menu.getName())) {
                return menu.getType();
            }
        }
        throw new IllegalArgumentException(ERROR_ORDER.getForm());
    }





}
