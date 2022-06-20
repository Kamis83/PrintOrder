package com.optimization.ratio;

import com.optimization.LayoutRatio;

public class OneOneDetector implements RatioDetector {
    @Override
    public boolean isRatio(int... orderSizes) {
        return orderSizes[0] == orderSizes[1];
    }

    @Override
    public LayoutRatio getRatio() {
        return LayoutRatio.ONE_ONE;
    }
}
