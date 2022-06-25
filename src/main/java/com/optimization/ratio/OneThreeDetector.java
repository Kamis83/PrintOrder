package com.optimization.ratio;

import com.optimization.LayoutRatio;

public class OneThreeDetector implements RatioDetector {
    @Override
    public boolean isRatio(int... orderQuantities) {
        int orderQuantityLeft = orderQuantities[0];
        int orderQuantityRight = orderQuantities[1];
        return orderQuantityLeft * 3 == orderQuantityRight || orderQuantityLeft == 3 * orderQuantityRight;
    }

    @Override
    public LayoutRatio getRatio() {
        return LayoutRatio.ONE_THREE;
    }
}

