package com.optimization.ratio;

import com.optimization.LayoutRatio;

public class OneOneOddDetector implements RatioDetector {
    @Override
    public boolean isRatio(int... orderQuantities) {
        int one = orderQuantities[0];
        int two = orderQuantities[1];
        int three = orderQuantities[2];
        return one == two || two == three || one == three;
    }

    @Override
    public LayoutRatio getRatio() {
        return LayoutRatio.ONE_ONE_ODD;
    }
}
