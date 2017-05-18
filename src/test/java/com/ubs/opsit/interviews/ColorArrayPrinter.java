package com.ubs.opsit.interviews;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public final class ColorArrayPrinter {

    private static final Collector<CharSequence, ?, String> JOINING_COLLECTOR = Collectors.joining();
    private static final Collector<CharSequence, ?, String> LINE_SEPARATING_COLLECTOR = Collectors
            .joining(System.lineSeparator());

    private ColorArrayPrinter() {
        // hide public constructor
    }

    public static String colorArrayToString(final ColorLight[][] expectedDisplay) {
        String result = Arrays.stream(expectedDisplay).map(mergeLightDisplayCharacters())
                .collect(LINE_SEPARATING_COLLECTOR);
        return result;
    }

    private static Function<ColorLight[], String> mergeLightDisplayCharacters() {
        return x -> Arrays.stream(x).map(ColorLight::displayCharacter).collect(JOINING_COLLECTOR);
    }
}
