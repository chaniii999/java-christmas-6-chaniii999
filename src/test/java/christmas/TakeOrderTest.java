package christmas;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static christmas.OutputView.OutputViewMessage.ERROR_ONLY_DRINK;
import static christmas.OutputView.OutputViewMessage.ERROR_ORDER;
import static christmas.OutputView.OutputViewMessage.ERROR_OVER_COUNT;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class TakeOrderTest extends ApplicationTest{

    @Test
    void inValidFormatThrowTest() {
        assertSimpleTest(() -> {
            runException("31","레드와인+1,티본스테이크-1");
            assertThat(output()).contains(ERROR_ORDER.getForm());
        });
    }

    @Test
    void inValidThrowTest() {
        assertSimpleTest(() -> {
            runException("31","레드와인 - 2");
            assertThat(output()).contains(ERROR_ORDER.getForm());
        });
    }

    @Test
    void duplicateThrowTest() {
        assertSimpleTest(() -> {
            runException("31","레드와인-1,레드와인-2,티본스테이크-4");
            assertThat(output()).contains(ERROR_ORDER.getForm());
        });
    }

    @Test
    void onlyDrinkThrowTest() {
        assertSimpleTest(() -> {
            runException("31","레드와인-1,제로콜라-2");
            assertThat(output()).contains(ERROR_ONLY_DRINK.getForm());
        });
    }



    @Test
    void overCountThrowTest() {
        assertSimpleTest(() -> {
            runException("31","레드와인-2,티본스테이크-20");
            assertThat(output()).contains(ERROR_OVER_COUNT.getForm());
        });
    }

    @Test
    void zeroCountThrowTest() {
        assertSimpleTest(() -> {
            runException("31","레드와인-2,티본스테이크-0");
            assertThat(output()).contains(ERROR_ORDER.getForm());
        });
    }

    @Test
    void minusCountThrowTest() {
        assertSimpleTest(() -> {
            runException("31","레드와인-20,티본스테이크--6");
            assertThat(output()).contains(ERROR_ORDER.getForm());
        });
    }

    @Test
    void invalidMenuThrowTest() {
        assertSimpleTest(() -> {
            runException("31","디분스테이크-5");
            assertThat(output()).contains(ERROR_ORDER.getForm());
        });
    }

}
