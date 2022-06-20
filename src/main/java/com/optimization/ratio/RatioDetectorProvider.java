package com.optimization.ratio;

import java.util.List;

public class RatioDetectorProvider {
    List<RatioDetector> getRatioDetectors(int orderCount) {
        return switch (orderCount) {
            case 2 -> List.of(new OneOneDetector(), new OneThreeDetector());
            case 3 ->  List.of(new OneOneTwoDetector(), new OneOneOddDetector());
            default -> throw new IllegalStateException("Unexpected value: " + orderCount);
        };
    }
}
