package com.optimization.ratio;

import com.optimization.LayoutRatio;

public class OneThreeDetector implements RatioDetector {
    @Override
    public boolean isRatio(int... sizes) {
        int orderSizeLeft = sizes[0];
        int orderSizeRight = sizes[1];
        return orderSizeLeft * 3 == orderSizeRight || orderSizeRight * 3 == orderSizeLeft;
    }

    @Override
    public LayoutRatio getRatio() {
        return LayoutRatio.ONE_THREE;
    }
}
