package christmas.SystemMessage;

public enum InputViewMessage {

    OPENING_MENT("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."),
    INPUT_DATE("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"),
    INPUT_MENU("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)"),

    ORDER_MENU("<주문 메뉴>"),
    PAYMENT_BEFORE_DISCOUNT("<할인 전 총주문 금액>"),
    GIVEAWAY_MENU("<증정 메뉴>"),
    BENEFITS("<혜택 내역>"),
    TOTAL_BENEFITS("<총혜택 내역>"),
    PAYMENT_EXPECT("<할인 후 예상 결제 금액>"),
    EVENT_BADGE("<12월 이벤트 배지>");





    private final String message;

    InputViewMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
