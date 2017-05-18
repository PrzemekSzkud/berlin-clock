package com.ubs.opsit.interviews;

import static com.ubs.opsit.interviews.ColorLight.RED;
import static com.ubs.opsit.interviews.ColorLight.OFF;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class BerlinTimeHoursDisplayTest {

    @Test
    public void methodForPrintingHoursExists() {
        // given
        NormalTime anyTime = new NormalTime(0, 0, 0);
        BerlinTimePrinter objectUnderTest = createObjectUnderTest();
        // when
        objectUnderTest.printableHour(anyTime);
    }

    @Test
    public void zeroHoursIsDisplayedAsAllTurnedOff() {
        // given
        int hour = 0;
        ColorLight[][] expectedDisplay = { { OFF, OFF, OFF, OFF }, { OFF, OFF, OFF, OFF } };
        // when then
        validateHoursDisplayedAsExpected(hour, expectedDisplay);
    }

    @Test
    public void oneHourIsDisplayedAsOneRedInLineTwo() {
        // given
        int hour = 1;
        ColorLight[][] expectedDisplay = { { OFF, OFF, OFF, OFF }, { RED, OFF, OFF, OFF } };
        // when then
        validateHoursDisplayedAsExpected(hour, expectedDisplay);
    }

    @Test
    public void sixHourIsDisplayedAsOneRedInLineOne() {
        // given
        int hour = 6;
        ColorLight[][] expectedDisplay = { { RED, OFF, OFF, OFF }, { RED, OFF, OFF, OFF } };
        // when then
        validateHoursDisplayedAsExpected(hour, expectedDisplay);
    }

    @Test
    public void elevelHourIsDisplayedAsTwoRedsInLineOne() {
        // given
        int hour = 11;
        ColorLight[][] expectedDisplay = { { RED, RED, OFF, OFF }, { RED, OFF, OFF, OFF } };
        // when then
        validateHoursDisplayedAsExpected(hour, expectedDisplay);
    }

    @Test
    public void twoHourIsDisplayedAsTwoRedsInLineTwo() {
        // given
        int hour = 2;
        ColorLight[][] expectedDisplay = { { OFF, OFF, OFF, OFF }, { RED, RED, OFF, OFF } };
        // when then
        validateHoursDisplayedAsExpected(hour, expectedDisplay);
    }

    @Test
    public void twentyFourHourIsDisplayedAsAllReds() {
        // given
        int hour = 24;
        ColorLight[][] expectedDisplay = { { RED, RED, RED, RED }, { RED, RED, RED, RED } };
        // when then
        validateHoursDisplayedAsExpected(hour, expectedDisplay);
    }

    private void validateHoursDisplayedAsExpected(final int hour, final ColorLight[][] expectedDisplay) {
        // given
        NormalTime time = new NormalTime(hour, 0, 0);
        BerlinTimePrinter objectUnderTest = createObjectUnderTest();
        // when
        String result = objectUnderTest.printableHour(time);
        // then
        assertThat(result, is(ColorArrayPrinter.colorArrayToString(expectedDisplay)));
    }

    private BerlinTimePrinter createObjectUnderTest() {
        return new BerlinTimePrinter();
    }
}
