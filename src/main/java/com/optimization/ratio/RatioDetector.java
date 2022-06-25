package com.optimization.ratio;

import com.optimization.LayoutRatio;

public interface RatioDetector {
    boolean isRatio(int  ... orderQuantities);
    LayoutRatio getRatio();
}
