package com.ubs.opsit.interviews;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.Mockito;

public class BerlinClockTimeConverterTest {

    private static final String TEST_TIME = "11:13:23";
    private static final String SOME_TIME_DISPLAY = "RRRORRR";
    private static final NormalTime TEST_NORMAL_TIME = new NormalTime(1, 1, 1);

    @Test(expected = IllegalArgumentException.class)
    public void nullResultsInException() {
        // given
        BerlinClockTimeConverter objectUnderTest = createObjectUnderTest(mock(NormalTimeFactory.class),
                mock(BerlinTimePrinter.class));
        // when
        objectUnderTest.convertTime(null);
        // then - exception
    }

    @Test
    public void converterRetrunsResultFromBerlinPrinter() {
        // given
        NormalTimeFactory normalTimeFactoryMock = createNormalTimeFactoryMock();
        BerlinTimePrinter berlinTimeMock = mock(BerlinTimePrinter.class);
        String testTimeDiplay = SOME_TIME_DISPLAY;
        when(berlinTimeMock.printableTime(Mockito.any())).thenReturn(testTimeDiplay);
        BerlinClockTimeConverter objectUnderTest = createObjectUnderTest(normalTimeFactoryMock, berlinTimeMock);
        // when
        String result = objectUnderTest.convertTime(TEST_TIME);
        // then
        assertThat(result, is(testTimeDiplay));
    }

    final BerlinClockTimeConverter createObjectUnderTest(final NormalTimeFactory normalTimeFactoryMock,
            final BerlinTimePrinter berlinTimeMock) {
        return new BerlinClockTimeConverter(normalTimeFactoryMock, berlinTimeMock);
    }

    final NormalTimeFactory createNormalTimeFactoryMock() {
        NormalTimeFactory normalTimeFactoryMock = mock(NormalTimeFactory.class);
        when(normalTimeFactoryMock.createTimeFromString(TEST_TIME)).thenReturn(TEST_NORMAL_TIME);
        return normalTimeFactoryMock;
    }

    @Test
    public void normalTimeWasPassedToBerlinPrinter() {
        NormalTimeFactory normalTimeFactoryMock = createNormalTimeFactoryMock();
        BerlinTimePrinter berlinTimeMock = mock(BerlinTimePrinter.class);
        BerlinClockTimeConverter objectUnderTest = createObjectUnderTest(normalTimeFactoryMock, berlinTimeMock);
        // when
        objectUnderTest.convertTime(TEST_TIME);
        // then
        verify(berlinTimeMock).printableTime(TEST_NORMAL_TIME);

    }

}
