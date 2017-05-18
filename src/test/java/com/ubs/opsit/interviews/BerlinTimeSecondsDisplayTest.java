package com.ubs.opsit.interviews;

import static com.ubs.opsit.interviews.ColorLight.OFF;
import static com.ubs.opsit.interviews.ColorLight.YELLOW;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class BerlinTimeSecondsDisplayTest {

    @Test
    public void methodForPrintingSecondsExists() {
        // given
        NormalTime anyTime = new NormalTime(0, 0, 0);
        BerlinTimePrinter objectUnderTest = createObjectUnderTest();
        // when
        objectUnderTest.printableSecond(anyTime);
    }

    @Test
    public void zeroSecondsAreDisplayedAsYellow() {
        // given
        int second = 0;
        ColorLight expectedDisplay = YELLOW;
        // when then
        validateSecondsDisplayedAsExpected(second, expectedDisplay);
    }

    private void validateSecondsDisplayedAsExpected(final int second, final ColorLight expectedDisplay) {
        // given
        NormalTime time = new NormalTime(0, 0, second);
        BerlinTimePrinter objectUnderTest = createObjectUnderTest();
        // when
        String result = objectUnderTest.printableSecond(time);
        // then
        assertThat(result, is(expectedDisplay.displayCharacter()));
    }

    @Test
    public void threeSecondsAreDisplayedAsTurnedOff() {
        // given
        int second = 3;
        ColorLight expectedDisplay = OFF;
        // when then
        validateSecondsDisplayedAsExpected(second, expectedDisplay);
    }

    @Test
    public void fiftyNineSecondsAreDisplayedAsTurnedOff() {
        // given
        int second = 59;
        ColorLight expectedDisplay = OFF;
        // when then
        validateSecondsDisplayedAsExpected(second, expectedDisplay);
    }

    private BerlinTimePrinter createObjectUnderTest() {
        return new BerlinTimePrinter();
    }
}
