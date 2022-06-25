package com.optimization;

import com.optimization.ratio.LayoutRatioCalculator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Optimization {

    private final LayoutRatioCalculator layoutRatioCalculator = new LayoutRatioCalculator();

    public List<Layout> optimize(List<SheetOrder> orders) {

        return switch (getLayoutRatio(orders)) {
            case FOUR_BY_FOUR -> List.of(singleOrderLayout());
            case ONE_ONE -> List.of(twoEqualOrdersLayout());
            case ONE_THREE -> List.of(oneToThreeOrderLayout());
            case ONE_ONE_TWO -> List.of(oneOneTwoLayout());
            case ONE_ONE_ODD -> List.of(twoEqualOrdersLayout(), singleOrderLayout());
            case ONE_ONE_ONE_ONE -> List.of(fourEqualOrdersLayout());
            case DOUBLE_ONE_ONE -> List.of(twoEqualOrdersLayout(), twoEqualOrdersLayout());
            case ONE_ONE_ODD_ODD -> List.of(twoEqualOrdersLayout(), singleOrderLayout(), singleOrderLayout());
            case ONE_ONE_TWO_ODD -> List.of(oneOneTwoLayout(), singleOrderLayout());
            case ALL_ODD -> getAllOddLayouts(orders.size());
        };
    }

    private List<Layout> getAllOddLayouts(int orderCount) {
        return IntStream.range(0, orderCount)
                .mapToObj(any -> singleOrderLayout())
                .collect(Collectors.toList());
    }

    private LayoutRatio getLayoutRatio(List<SheetOrder> orders) {
        return layoutRatioCalculator.getLayoutRatio(getOrderQuantities(orders));
    }


    private List<Integer> getOrderQuantities(List<SheetOrder> orders) {
        return orders.stream()
                .map(SheetOrder::quantityOfOrder)
                .collect(Collectors.toList());
    }

    private Layout fourEqualOrdersLayout() {
        return new Layout(
                "1/4 + 1/4 + 1/4 + 1/4", 2, "without overturn");
    }

    private Layout oneOneTwoLayout() {
        return new Layout("1/4 + 1/4 + 2/4", 2, "without overturn");
    }

    private Layout oneToThreeOrderLayout() {
        return new Layout("1/4 + 3/4", 2, "without overturn");
    }

    private Layout twoEqualOrdersLayout() {
        return new Layout("2/4 + 2/4", 1, "side overturn");
    }


    private Layout singleOrderLayout() {
        return new Layout("4/4", 1, "side overturn");
    }
}




