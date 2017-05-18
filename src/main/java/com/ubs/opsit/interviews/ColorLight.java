package com.ubs.opsit.interviews;

enum ColorLight {

    OFF("O"), RED("R"), YELLOW("Y");

    private final String displayCharacter;

    ColorLight(final String displayCharacter) {
        this.displayCharacter = displayCharacter;
    }

    String displayCharacter() {
        return displayCharacter;
    }
}
