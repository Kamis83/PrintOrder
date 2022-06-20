package com.optimization.ratio;

import com.optimization.LayoutRatio;
import com.optimization.ratio.RatioDetector;
import com.optimization.ratio.RatioDetectorProvider;

import java.util.List;

public class LayoutRatioCalculator {
    private final RatioDetectorProvider ratioDetectorProvider = new RatioDetectorProvider();

    public LayoutRatio getLayoutRatio(List<Integer> orderSizes) {
        List<RatioDetector> ratioDetectors = ratioDetectorProvider.getRatioDetectors(orderSizes.size());
        for (RatioDetector detector : ratioDetectors) {
            if (detector.isRatio(orderSizes.stream().mapToInt(Integer::intValue).toArray())) {
                return detector.getRatio();
            }
        }
        return LayoutRatio.ALL_ODD;
    }
}