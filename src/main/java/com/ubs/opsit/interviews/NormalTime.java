package com.ubs.opsit.interviews;

final class NormalTime {

    private final int hour;
    private final int minute;
    private final int second;

    NormalTime(final int hour, final int minute, final int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    int getHour() {
        return this.hour;
    }

    int getMinute() {
        return this.minute;
    }

    int getSecond() {
        return this.second;
    }
}
