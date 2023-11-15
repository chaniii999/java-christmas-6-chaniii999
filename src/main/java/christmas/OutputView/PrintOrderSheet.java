package christmas.OutputView;

import static christmas.OutputView.OutputViewMessage.FORM_MENU;
import static christmas.OutputView.OutputViewMessage.FORM_PREVIEW_EVENT;
import static christmas.OutputView.OutputViewMessage.ORDER_MENU;

import christmas.model.Menu;
import christmas.model.OrderSheet;

public class PrintOrderSheet {

    public PrintOrderSheet(OrderSheet orderSheet, int date) {
        System.out.printf(FORM_PREVIEW_EVENT.getForm(), date);
        System.out.println();
        System.out.println(ORDER_MENU.getForm());

        printOrderSheet(orderSheet);
    }

    private void printOrderSheet(OrderSheet orderSheet) {
        for(Menu menu : orderSheet.getOrderSheet() ) {
            System.out.printf(FORM_MENU.getForm(), menu.getName(), menu.getCount());
        }
        System.out.println();
    }

}
