package christmas;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class BadgeTest extends ApplicationTest {

    @Test
    void nonBadgeTest() {
        assertSimpleTest(() -> {
            run("18", "초코케이크-1");
            assertThat(output()).doesNotContain(
                "산타",
                "트리",
                "별"
            );
        });
    }

    @Test
    void santaTest() {
        assertSimpleTest(() -> {
            run("18", "티본스테이크-2,레드와인-2");
            assertThat(output()).contains(
                "산타"
            );
        });
    }

    @Test
    void treeTest() {
        assertSimpleTest(() -> {
            run("25", "티본스테이크-1,크리스마스파스타-2");
            assertThat(output()).contains(
                "별"
            );
        });
    }

    @Test
    void starTest() {
        assertSimpleTest(() -> {
            run("18", "초코케이크-2,레드와인-1");
            assertThat(output()).contains(
                "별"
            );
        });
    }

}
