package com.optimization.ratio;

import com.optimization.LayoutRatio;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OneOneOddOddDetector implements RatioDetector {
    @Override
    public boolean isRatio(int... orderQuantities) {
        int one = orderQuantities[0];
        int two = orderQuantities[1];
        int three = orderQuantities[2];
        int four = orderQuantities[3];

    return areTwoOfFourOrdersEqual(one, two, three, four);

    }

    @Override
    public LayoutRatio getRatio() {
        return (LayoutRatio.ONE_ONE_ODD_ODD);
    }

    private boolean areTwoOfFourOrdersEqual(int one, int two, int three, int four) {
        return Stream.of(one, two, three, four)
                .distinct()
                .count() == 3;
    }
}

