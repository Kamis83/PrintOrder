package com.optimization.ratio;

import com.optimization.LayoutRatio;

import java.util.List;

public class LayoutRatioCalculator {
    private final RatioDetectorProvider ratioDetectorProvider = new RatioDetectorProvider();

    public LayoutRatio getLayoutRatio(List<Integer> orderQuantities){
        List<RatioDetector> ratioDetectors = ratioDetectorProvider.getRatioDetectors(orderQuantities.size());
        for(RatioDetector detector:ratioDetectors){
            if(detector.isRatio(orderQuantities.stream().mapToInt(Integer::intValue).toArray())){
                return detector.getRatio();
            }
        }
        return LayoutRatio.ALL_ODD;
    }
}
