package com.ubs.opsit.interviews;

import static com.ubs.opsit.interviews.ColorLight.OFF;
import static com.ubs.opsit.interviews.ColorLight.RED;
import static com.ubs.opsit.interviews.ColorLight.YELLOW;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;

class BerlinTimePrinter {

    private static final int MAX_HOUR_LIGHTS_IN_LINE_ONE = 4;
    private static final int MAX_MINUTES_LIGHTS_IN_LINE_ONE = 11;
    private static final int MAX_LIGHTS_IN_LINE_TWO = 4;
    private static final int MINUTE_RED_LIGHT_FREQUENCY = 3;
    private static final int TIME_DIVIDER = 5;

    String printableTime(final NormalTime normalTime) {
        return joinLines(printableSecond(normalTime), printableHour(normalTime), printableMinute(normalTime));
    }

    String printableSecond(final NormalTime normalTime) {
        final ColorLight colorLight;
        if (normalTime.getSecond() % 2 == 0) {
            colorLight = ColorLight.YELLOW;
        } else {
            colorLight = ColorLight.OFF;
        }
        return colorLight.displayCharacter();
    }

    String printableHour(final NormalTime normalTime) {
        return joinLines(printableHourLineOne(normalTime), printableHourLineTwo(normalTime));
    }

    String printableMinute(final NormalTime normalTime) {
        return joinLines(printableMinuteLineOne(normalTime), printableMinuteLineTwo(normalTime));
    }

    private String joinLines(final String... lines) {
        return String.join(System.lineSeparator(), lines);
    }

    private String printableHourLineTwo(final NormalTime normalTime) {
        int numberOfLightsOn = normalTime.getHour() % TIME_DIVIDER;
        return printableLine(numberOfLightsOn, this::repeatRedLight, MAX_LIGHTS_IN_LINE_TWO);
    }

    private String printableMinuteLineTwo(final NormalTime normalTime) {
        int numberOfLightsOn = normalTime.getMinute() % TIME_DIVIDER;
        return printableLine(numberOfLightsOn, this::repeatYellowLight, MAX_LIGHTS_IN_LINE_TWO);
    }

    private String printableHourLineOne(final NormalTime normalTime) {
        int numberOfLightsOn = normalTime.getHour() / TIME_DIVIDER;
        return printableLine(numberOfLightsOn, this::repeatRedLight, MAX_HOUR_LIGHTS_IN_LINE_ONE);
    }

    private String printableMinuteLineOne(final NormalTime normalTime) {
        int numberOfLightsOn = normalTime.getMinute() / TIME_DIVIDER;
        return printableLine(numberOfLightsOn, this::repeatMinuteLightLineOne, MAX_MINUTES_LIGHTS_IN_LINE_ONE);
    }

    private String printableLine(final int numberOfLightsOn, final Function<Integer, String> repeatingFunction,
            final int maximumCharacters) {
        String lightsOnString = repeatingFunction.apply(numberOfLightsOn);
        return appendWithTurnedOff(lightsOnString, maximumCharacters - numberOfLightsOn);
    }

    private String repeatMinuteLightLineOne(final int minuteLigthsOn) {
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= minuteLigthsOn; i++) {
            if (i % MINUTE_RED_LIGHT_FREQUENCY == 0) {
                result.append(RED.displayCharacter());
            } else {
                result.append(YELLOW.displayCharacter());
            }
        }
        return result.toString();
    }

    private String appendWithTurnedOff(final String toAppend, final int hourLightsOff) {
        return toAppend.concat(repeatLight(OFF, hourLightsOff));
    }

    private String repeatRedLight(final int numberOfLightsOn) {
        return repeatLight(RED, numberOfLightsOn);
    }

    private String repeatYellowLight(final int numberOfLightsOn) {
        return repeatLight(YELLOW, numberOfLightsOn);
    }

    private String repeatLight(final ColorLight colorLight, final int number) {
        List<String> copies = Collections.nCopies(number, colorLight.displayCharacter());
        return String.join("", copies);
    }
}
