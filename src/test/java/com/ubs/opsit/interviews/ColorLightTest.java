package com.ubs.opsit.interviews;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class ColorLightTest {

    @Test
    public void getDisplayCharacterMethodExists() {
        // when
        ColorLight.RED.displayCharacter();
    }

    @Test
    public void displayForYellowIsY() {
        // when
        String result = ColorLight.YELLOW.displayCharacter();
        // then
        assertThat(result, is("Y"));
    }
}
