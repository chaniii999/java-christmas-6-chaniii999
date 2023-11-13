package christmas.InputView;

import static christmas.InputView.InputViewMessage.INPUT_DATE;
import static christmas.InputView.InputViewMessage.OPENING_MENT;
import static christmas.OutputView.OutputViewMessage.ERROR_DATE;

import camp.nextstep.edu.missionutils.Console;

public class VisitDate {
    private final int FIRST_DATE = 1;
    private final int END_DATE = 31;

    private final int date;

    public VisitDate() {
        System.out.println(OPENING_MENT.getMessage());
        System.out.println(INPUT_DATE.getMessage());
        this.date = validateDate();
    }
    
    private int validateDate() {
        int result;
        while (true) {
            try {
                result = validateInput();
                if (result < FIRST_DATE || result > END_DATE)
                    throw new IllegalArgumentException(ERROR_DATE.getForm());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return result;
    }
    
    private int validateInput() {
        int result;
        try {
            String input = Console.readLine();
            result = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_DATE.getForm());
        }
        return result;
    }
    
    public int getDate() {
        return date;
    }
}
