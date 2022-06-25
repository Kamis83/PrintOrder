package com.optimization.ratio;

import com.optimization.LayoutRatio;

public class DoubleOneOneDetector implements RatioDetector {
    @Override
    public boolean isRatio(int... orderQuantities) {
        int one = orderQuantities[0];
        int two = orderQuantities[1];
        int three = orderQuantities[2];
        int four = orderQuantities[3];
        return one == two && three == four ||
                two == three && one == four ||
                one == three && two == four;
    }

    @Override
    public LayoutRatio getRatio() {
        return LayoutRatio.DOUBLE_ONE_ONE;
    }
}
