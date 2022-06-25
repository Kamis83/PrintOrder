package com.optimization.ratio;

import com.optimization.LayoutRatio;

public class OneOneDetector implements RatioDetector {
    @Override
    public boolean isRatio(int... orderQuantities) {
        return orderQuantities[0] == orderQuantities[1];
    }
    @Override
    public LayoutRatio getRatio() {
        return LayoutRatio.ONE_ONE;
    }
}

