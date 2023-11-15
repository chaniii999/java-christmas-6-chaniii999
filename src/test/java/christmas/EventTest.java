package christmas;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class EventTest extends ApplicationTest{

    @Test
    void giveawayTest() {
        assertSimpleTest(() -> {
            run("3", "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
            assertThat(output()).contains(
                "<증정 메뉴>",
                "샴페인 1개",
                "<혜택 내역>",
                "증정 이벤트: -25,000원"
            );
        });
    }

    @Test
    void nonGiveawayTest() {
        assertSimpleTest(() -> {
            run("3", "초코케이크-2,제로콜라-1");
            assertThat(output()).doesNotContain(
                "샴페인 1개",
                "증정 이벤트: -25,000원"
            );
        });
    }

    @Test
    void xmasDdayTest() {
        assertSimpleTest(() -> {
            run("25", "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
            assertThat(output()).contains(
                "크리스마스 디데이 할인: -3,400원"
            );
        });
    }

    @Test
    void nonXmasDdayTest() {
        assertSimpleTest(() -> {
            run("26", "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
            assertThat(output()).doesNotContain(
                "크리스마스 디데이 할인"
            );
        });
    }

    @Test
    void specialXmasTest() {
        assertSimpleTest(() -> {
            run("25", "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
            assertThat(output()).contains(
                "특별 할인: -1,000원"
            );
        });
    }

    @Test
    void specialSundayTest() {
        assertSimpleTest(() -> {
            run("31", "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
            assertThat(output()).contains(
                "특별 할인: -1,000원"
            );
        });
    }

    @Test
    void nonSpecialTest() {
        assertSimpleTest(() -> {
            run("30", "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
            assertThat(output()).doesNotContain(
                "특별 할인: -1,000원"
            );
        });
    }

    @Test
    void weekdayTest() {
        assertSimpleTest(() -> {
            run("18", "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
            assertThat(output()).contains(
                "평일 할인"
            );
        });
    }

    @Test
    void nonweekdayTest() {
        assertSimpleTest(() -> {
            run("15", "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
            assertThat(output()).doesNotContain(
                "평일 할인"
            );
            run("16", "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
            assertThat(output()).contains(
                "주말 할인"
            );
        });
    }

    @Test
    void weekendTest() {
        assertSimpleTest(() -> {
            run("15", "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
            assertThat(output()).contains(
                "주말 할인"
            );
            run("16", "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
            assertThat(output()).contains(
                "주말 할인"
            );
        });
    }

    @Test
    void nonweekendTest() {
        assertSimpleTest(() -> {
            run("18", "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
            assertThat(output()).doesNotContain(
                "주말 할인"
            );
        });
    }


}
