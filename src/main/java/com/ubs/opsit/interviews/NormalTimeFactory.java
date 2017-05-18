package com.ubs.opsit.interviews;

import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.TemporalAccessor;

class NormalTimeFactory {

    private static final int HOURS_IN_DAY = 24;
    private static final String TIME_PATTERN = "HH:mm:ss";
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern(TIME_PATTERN);

    NormalTime createTimeFromString(final String aTime) {
        try {
            return tryCreateTimeFromString(aTime);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException(e);
        }
    }

    NormalTime tryCreateTimeFromString(final String aTime) {
        TemporalAccessor parsedDateTime = TIME_FORMATTER.parse(aTime);
        LocalTime localTime = LocalTime.from(parsedDateTime);

        int hour = calculateHourIncludingTwoMidnights(parsedDateTime, localTime.getHour());
        return createNormalTime(hour, localTime.getMinute(), localTime.getSecond());
    }

    NormalTime createNormalTime(final int hour, final int minute, final int second) {
        return new NormalTime(hour, minute, second);
    }

    private int calculateHourIncludingTwoMidnights(final TemporalAccessor parsedDateTime, final int hourOfTheDay) {
        final int calculatedHour;
        if (isNextDay(parsedDateTime)) {
            calculatedHour = hourOfTheDay + HOURS_IN_DAY;
        } else {
            calculatedHour = hourOfTheDay;
        }
        return calculatedHour;
    }

    private boolean isNextDay(final TemporalAccessor parsedDateTime) {
        Period excessDays = parsedDateTime.query(DateTimeFormatter.parsedExcessDays());
        boolean isNextDay = excessDays.equals(Period.ofDays(1));
        return isNextDay;
    }
}
