package com.optimization.ratio;

import com.optimization.LayoutRatio;

public class OneOneOneOneDetector implements RatioDetector{
    @Override
    public boolean isRatio(int... orderQuantities) {
        return  orderQuantities[0] == orderQuantities[1] &&
                orderQuantities[2] == orderQuantities[3] &&
                orderQuantities[0] == orderQuantities[2];
    }

    @Override
    public LayoutRatio getRatio() {
        return LayoutRatio.ONE_ONE_ONE_ONE;
    }

}
