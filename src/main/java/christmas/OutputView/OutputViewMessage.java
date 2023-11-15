package christmas.OutputView;

public enum OutputViewMessage {

    FORM_PREVIEW_EVENT("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n"),

    FORM_MENU("%s %d개\n"),
    FORM_PAYMENT("%,d원\n"),
    FORM_BENEFIT("%s: %,d원\n"),

    ORDER_MENU("<주문 메뉴>"),
    PAYMENT_BEFORE_DISCOUNT("<할인 전 총주문 금액>"),
    GIVEAWAY_MENU("<증정 메뉴>"),
    BENEFITS("<혜택 내역>"),
    TOTAL_BENEFITS("<총혜택 금액>"),
    PAYMENT_EXPECT("<할인 후 예상 결제 금액>"),
    EVENT_BADGE("<12월 이벤트 배지>"),

    BADGE_STAR("별"),
    BADGE_TREE("트리"),
    BADGE_SANTA("산타"),

    NO_BENEFIT("없음"),

    ERROR_DATE("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    ERROR_ORDER("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."),
    ERROR_ONLY_DRINK("[ERROR] 음료만 주문하는 것은 불가능합니다. 다시 입력해 주세요."),
    ERROR_OVER_COUNT("[ERROR] 총 20개까지 주문 가능합니다. 다시 입력해 주세요.");

    private final String Form;

    OutputViewMessage(String Form) {
        this.Form = Form;
    }

    public String getForm() {
        return Form;
    }
}
