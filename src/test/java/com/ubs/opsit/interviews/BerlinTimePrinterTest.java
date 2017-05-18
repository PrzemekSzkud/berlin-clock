package com.ubs.opsit.interviews;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class BerlinTimePrinterTest {

    private static final NormalTime ANY_TIME = new NormalTime(15, 22, 1);
    private static final String SEPARATOR = System.lineSeparator();

    @Test
    public void methodForPrintingTimeExists() {
        // given
        NormalTime anyTime = new NormalTime(0, 0, 0);
        // when
        createObjectUnderTest().printableTime(anyTime);
    }

    @Test
    public void timeIsMergedFromSecondsHoursAndMinutes() {
        // given
        NormalTime time = ANY_TIME;
        BerlinTimePrinter objectUnderTest = createObjectUnderTest();
        String expectedResult = objectUnderTest.printableSecond(time) + SEPARATOR + objectUnderTest.printableHour(time)
                + SEPARATOR + objectUnderTest.printableMinute(time);
        // when
        String result = objectUnderTest.printableTime(time);
        // then
        assertThat(result, is(expectedResult));
    }

    private BerlinTimePrinter createObjectUnderTest() {
        return new BerlinTimePrinter();
    }
}
