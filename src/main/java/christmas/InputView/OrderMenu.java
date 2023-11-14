package christmas.InputView;

import static christmas.InputView.InputViewMessage.INPUT_MENU;
import static christmas.OutputView.OutputViewMessage.ERROR_ONLY_DRINK;
import static christmas.OutputView.OutputViewMessage.ERROR_ORDER;
import static christmas.OutputView.OutputViewMessage.ERROR_OVER_COUNT;

import camp.nextstep.edu.missionutils.Console;
import christmas.domain.AllMenu;
import java.util.HashSet;
import java.util.Set;

public class OrderMenu {
    private final String ORDER_FORMAT = "^[가-힣]+-\\d+$";
    private final String ORDER_SEPARATOR = ",";
    private final String MENU_SEPARATOR = "-";
    private final int MIN_COUNT = 1;
    private final int MAX_TOTAL = 20;

    private final String[] menuItems;

    public OrderMenu (AllMenu allMenu) {
        System.out.println(INPUT_MENU.getMessage());
        this.menuItems = inputOrder(allMenu);
    }

    private String[] inputOrder(AllMenu allMenu) {
        String[] menuItems;

        while (true) {
            try {
                String input = Console.readLine();
                menuItems = input.split(ORDER_SEPARATOR);
                validateInput(menuItems, allMenu);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return menuItems;
    }

    private void validateInput(String[] input, AllMenu allMenu) {
        validateFormat(input);
        validateCount(input);
        hasDuplicates(input);
        hasOnlyDrink(input, allMenu);
    }

    private void validateFormat(String[] input) {
        for (String order : input) {
            if (!order.matches(ORDER_FORMAT))
                throw new IllegalArgumentException(ERROR_ORDER.getForm());
        }
    }

    private void validateCount(String[] input) {
        int totalMenuCount = 0;

        for (String order : input) {
            int foodCount = Integer.parseInt(order.split(MENU_SEPARATOR)[1]);

            if (foodCount < MIN_COUNT)
                throw new IllegalArgumentException(ERROR_ORDER.getForm());

            totalMenuCount += foodCount;
        }
        if (totalMenuCount > MAX_TOTAL)
            throw new IllegalArgumentException(ERROR_OVER_COUNT.getForm());
    }

    private void hasDuplicates(String[] input) {
        Set<String> noDup = new HashSet<>();

        for (String order : input) {
            String menuName= order.split(MENU_SEPARATOR)[0];

            if (!noDup.add(menuName))
                throw new IllegalArgumentException(ERROR_ORDER.getForm());
        }
    }

    private void hasOnlyDrink(String[] input, AllMenu allMenu) {
            int drinkCount = 0;

            for (String order : input) {
                String menuName = order.split(MENU_SEPARATOR)[0];

                if (allMenu.searchType(menuName).equals("음료"))
                    drinkCount++;
            }
            if (drinkCount == input.length)
                throw new IllegalArgumentException(ERROR_ONLY_DRINK.getForm());
    }

    public String[] getMenuItems() {
        return menuItems;
    }

}
