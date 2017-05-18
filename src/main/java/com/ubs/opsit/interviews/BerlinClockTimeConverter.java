package com.ubs.opsit.interviews;

/**
 * Class converts given time to a Berlin time format using String characters to
 * represent color lights.
 *
 * @author pszkudla
 */
public final class BerlinClockTimeConverter implements TimeConverter {

    private final NormalTimeFactory normalTimeFactory;
    private final BerlinTimePrinter berlinTimePrinter;

    public BerlinClockTimeConverter(final NormalTimeFactory normalTimeFactory,
            final BerlinTimePrinter berlinTimePrinter) {
        this.normalTimeFactory = normalTimeFactory;
        this.berlinTimePrinter = berlinTimePrinter;
    }

    @Override
    public String convertTime(final String aTime) {
        if (aTime == null) {
            throw new IllegalArgumentException();
        }
        NormalTime normalTime = normalTimeFactory.createTimeFromString(aTime);
        return berlinTimePrinter.printableTime(normalTime);
    }
}
