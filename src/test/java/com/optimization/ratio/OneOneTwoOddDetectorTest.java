package com.optimization.ratio;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OneOneTwoOddDetectorTest {

    @Test
    void isRatioOneOneTwoOdd() {
        int one = 1000;
        int two = 1000;
        int three = 1000;
        int four = 2000;
        OneOneTwoOddDetector oneOneTwoOddDetector = new OneOneTwoOddDetector();
        boolean actual = oneOneTwoOddDetector.isRatio(one, two, three, four);

        assertTrue(actual);


    }
    @Test
    void isRatioNotOneOneTwoOdd() {
        int one = 3000;
        int two = 9000;
        int three = 11000;
        int four = 10000;
        OneOneTwoOddDetector oneOneTwoOddDetector = new OneOneTwoOddDetector();
        boolean actual = oneOneTwoOddDetector.isRatio(one, two, three, four);

        assertFalse(actual);


    }
}