package com.optimization.ratio;

import com.optimization.LayoutRatio;

public class OneOneTwoDetector implements RatioDetector {
    @Override
    public boolean isRatio(int... orderSizes) {
        int one = orderSizes[0];
        int two = orderSizes[1];
        int three = orderSizes[2];
        return isOneOneTwoPermutation(one, two, three) ||
                isOneOneTwoPermutation(one, three, two) ||
                isOneOneTwoPermutation(three, two, one);
    }

    @Override
    public LayoutRatio getRatio() {
        return LayoutRatio.ONE_ONE_TWO;
    }

    private boolean isOneOneTwoPermutation(int one, int three, int two) {
        return one * 2 == three && two * 2 == three;
    }
}
