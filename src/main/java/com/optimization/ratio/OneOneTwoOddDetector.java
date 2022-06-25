package com.optimization.ratio;

import com.optimization.LayoutRatio;
import com.optimization.ratio.RatioDetector;

public class OneOneTwoOddDetector implements RatioDetector {
    @Override
    public boolean isRatio(int... orderQuantities) {
        int one = orderQuantities[0];
        int two = orderQuantities[1];
        int three = orderQuantities[2];
        int four = orderQuantities[3];
        return isOneOneTwoOddPermutation(one, two, three, four) ||
                isOneOneTwoOddPermutation(three, one, two, four) ||
                isOneOneTwoOddPermutation(two, three, one, four) ||
                isOneOneTwoOddPermutation(one, two, four, three) ||
                isOneOneTwoOddPermutation(four, one, two, three) ||
                isOneOneTwoOddPermutation(two, four, one, three);
    }

    @Override
    public LayoutRatio getRatio() {
        return LayoutRatio.ONE_ONE_TWO_ODD;
    }

    private boolean isOneOneTwoOddPermutation(int one, int two, int three, int four) {
        return one * 2 == three && two * 2 == three ||
                one * 2 == four && two * 2 == four;
    }

}
