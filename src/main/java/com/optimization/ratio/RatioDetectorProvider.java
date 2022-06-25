package com.optimization.ratio;

import com.optimization.FourByFourDetector;

import java.util.List;

public class RatioDetectorProvider {
    List<RatioDetector> getRatioDetectors(int orderItemCount) {
        return switch (orderItemCount) {
            case 1 -> List.of(new FourByFourDetector());
            case 2 -> List.of(new OneOneDetector(), new OneThreeDetector());
            case 3 -> List.of(new OneOneTwoDetector(), new OneOneOddDetector());
            case 4 -> List.of(new OneOneOneOneDetector(), new DoubleOneOneDetector(),
                    new OneOneOddOddDetector(), new OneOneTwoOddDetector());
            default -> throw new IllegalStateException("Unexpected value: " + orderItemCount);
        };
    }
}
