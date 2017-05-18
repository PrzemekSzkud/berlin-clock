package com.ubs.opsit.interviews;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class NormalTimeFactoryTest {

    private static final String MIDNIGHT = "00:00:00";
    private static final String MIDNIGHT_NEXT_DAY = "24:00:00";

    @Test
    public void methodForCreatingTimeExists() {
        // when
        createObjectUnderTest().createTimeFromString(MIDNIGHT);
    }

    @Test
    public void hourIsExtractedFromMidnight() {
        // when
        NormalTime time = createObjectUnderTest().createTimeFromString(MIDNIGHT);
        // then
        assertThat(time.getHour(), is(0));
    }

    private NormalTimeFactory createObjectUnderTest() {
        return new NormalTimeFactory();
    }

    @Test
    public void minuteIsExtractedFromMidnight() {
        // when
        NormalTime time = createObjectUnderTest().createTimeFromString(MIDNIGHT);
        // then
        assertThat(time.getMinute(), is(0));
    }

    @Test
    public void secondIsExtractedFromMidnight() {
        // when
        NormalTime time = createObjectUnderTest().createTimeFromString(MIDNIGHT);
        // then
        assertThat(time.getSecond(), is(0));
    }

    @Test
    public void hourIsExtractedFromNoon() {
        // when
        NormalTime time = createObjectUnderTest().createTimeFromString("12:00:00");
        // then
        assertThat(time.getHour(), is(12));
    }

    @Test
    public void minuteIsExtractedFromTime() {
        // when
        NormalTime time = createObjectUnderTest().createTimeFromString("12:11:00");
        // then
        assertThat(time.getMinute(), is(11));
    }

    @Test
    public void secondIsExtractedFromTime() {
        // when
        NormalTime time = createObjectUnderTest().createTimeFromString("12:11:13");
        // then
        assertThat(time.getSecond(), is(13));
    }

    @Test
    public void midnightNextDayHourIs24() {
        // when
        NormalTime time = createObjectUnderTest().createTimeFromString(MIDNIGHT_NEXT_DAY);
        // then
        assertThat(time.getHour(), is(24));
    }

    @Test(expected = IllegalArgumentException.class)
    public void incorrectTimeConvertionTest() {
        // when
        createObjectUnderTest().createTimeFromString("28:00:00");
        // then - exception
    }

}
