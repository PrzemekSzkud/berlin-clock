package com.ubs.opsit.interviews;

import static com.ubs.opsit.interviews.ColorLight.RED;
import static com.ubs.opsit.interviews.ColorLight.YELLOW;
import static com.ubs.opsit.interviews.ColorLight.OFF;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class BerlinTimeMinutesDisplayTest {

    @Test
    public void methodForPrintingMinuteExists() {
        // given
        NormalTime anyTime = new NormalTime(0, 0, 0);
        BerlinTimePrinter objectUnderTest = createObjectUnderTest();
        // when
        objectUnderTest.printableMinute(anyTime);
    }

    @Test
    public void zeroMinutesAreDisplayedAsAllTurnedOff() {
        // given
        int minute = 0;
        ColorLight[][] expectedDisplay = { { OFF, OFF, OFF, OFF, OFF, OFF, OFF, OFF, OFF, OFF, OFF },
                { OFF, OFF, OFF, OFF } };
        // when then
        validateMinutesDisplayedAsExpected(minute, expectedDisplay);
    }

    @Test
    public void threeMinutesAreDisplayedAsThreeYellowInSecondLine() {
        // given
        int minute = 3;
        ColorLight[][] expectedDisplay = { { OFF, OFF, OFF, OFF, OFF, OFF, OFF, OFF, OFF, OFF, OFF },
                { YELLOW, YELLOW, YELLOW, OFF } };
        // when then
        validateMinutesDisplayedAsExpected(minute, expectedDisplay);
    }

    @Test
    public void fiveMinutesAreDisplayedAsOneYellowInFirstLine() {
        // given
        int minute = 5;
        ColorLight[][] expectedDisplay = { { YELLOW, OFF, OFF, OFF, OFF, OFF, OFF, OFF, OFF, OFF, OFF },
                { OFF, OFF, OFF, OFF } };
        // when then
        validateMinutesDisplayedAsExpected(minute, expectedDisplay);
    }

    @Test
    public void sixMinutesAreDisplayedAsOneYellowInFirstLineAndOneInSecond() {
        // given
        int minute = 6;
        ColorLight[][] expectedDisplay = { { YELLOW, OFF, OFF, OFF, OFF, OFF, OFF, OFF, OFF, OFF, OFF },
                { YELLOW, OFF, OFF, OFF } };
        // when then
        validateMinutesDisplayedAsExpected(minute, expectedDisplay);
    }

    @Test
    public void fifteenMinutesAreDisplayedAsTwoYellowsAndOneRedInFirstLine() {
        // given
        int minute = 15;
        ColorLight[][] expectedDisplay = { { YELLOW, YELLOW, RED, OFF, OFF, OFF, OFF, OFF, OFF, OFF, OFF },
                { OFF, OFF, OFF, OFF } };
        // when then
        validateMinutesDisplayedAsExpected(minute, expectedDisplay);
    }

    private void validateMinutesDisplayedAsExpected(final int minute, final ColorLight[][] expectedDisplay) {
        // given
        NormalTime time = new NormalTime(0, minute, 0);
        BerlinTimePrinter objectUnderTest = createObjectUnderTest();
        // when
        String result = objectUnderTest.printableMinute(time);
        // then
        assertThat(result, is(ColorArrayPrinter.colorArrayToString(expectedDisplay)));
    }

    private BerlinTimePrinter createObjectUnderTest() {
        return new BerlinTimePrinter();
    }
}
