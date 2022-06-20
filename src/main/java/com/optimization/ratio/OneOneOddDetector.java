package com.optimization.ratio;

import com.optimization.LayoutRatio;

public class OneOneOddDetector implements RatioDetector {
    @Override
    public boolean isRatio(int... sizes) {
        int one = sizes[0];
        int two = sizes[1];
        int three = sizes[2];
        return one == two || two == three || one == three;
    }

    @Override
    public LayoutRatio getRatio() {
        return LayoutRatio.ONE_ONE_ODD;
    }


}
