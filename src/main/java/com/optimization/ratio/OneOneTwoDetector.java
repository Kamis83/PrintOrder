package com.optimization.ratio;

import com.optimization.LayoutRatio;

public class OneOneTwoDetector implements RatioDetector {
    @Override
    public boolean isRatio(int... orderQuantities) {
        int one = orderQuantities[0];
        int two = orderQuantities[1];
        int three = orderQuantities[2];
        return isOneOneTwoPermutation(one, two, three) ||
                isOneOneTwoPermutation(three, one, two) ||
                isOneOneTwoPermutation(two, three, one);
    }

    @Override
    public LayoutRatio getRatio() {
        return LayoutRatio.ONE_ONE_TWO;
    }

    private boolean isOneOneTwoPermutation(int one, int two, int three) {
        return one * 2 == three && two * 2 == three;
    }


}
