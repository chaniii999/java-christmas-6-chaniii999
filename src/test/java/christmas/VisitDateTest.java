package christmas;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static christmas.OutputView.OutputViewMessage.ERROR_DATE;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class VisitDateTest extends ApplicationTest {



    @Test
    void overRangeThrowTest() {
        assertSimpleTest(() -> {
            runException("32");
            assertThat(output()).contains(ERROR_DATE.getForm());
        });
    }

    @Test
    void zeroThrowTest() {
        assertSimpleTest(() -> {
            runException("0");
            assertThat(output()).contains(ERROR_DATE.getForm());
        });
    }

    @Test
    void underRangeThrowTest() {
        assertSimpleTest(() -> {
            runException("-5");
            assertThat(output()).contains(ERROR_DATE.getForm());
        });
    }

    @Test
    void inValidThrowTest() {
        assertSimpleTest(() -> {
            runException("31k");
            assertThat(output()).contains(ERROR_DATE.getForm());
        });
    }


}
