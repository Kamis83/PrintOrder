package com.optimization;

import com.optimization.ratio.RatioDetector;

public class FourByFourDetector implements RatioDetector {
    @Override
    public boolean isRatio(int... orderQuantities) {
        return true;
    }

    @Override
    public LayoutRatio getRatio() {
        return LayoutRatio.FOUR_BY_FOUR;
    }
}
