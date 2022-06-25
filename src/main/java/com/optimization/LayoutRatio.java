package com.optimization;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public enum LayoutRatio {
    FOUR_BY_FOUR(List.of(singleOrderLayout())),
    ONE_ONE(List.of(twoEqualOrdersLayout())),
    ONE_THREE(List.of(oneToThreeOrderLayout())),
    ONE_ONE_TWO(List.of(oneOneTwoLayout())),
    ONE_ONE_ODD(List.of(twoEqualOrdersLayout(), singleOrderLayout())),
    ONE_ONE_ONE_ONE(List.of(fourEqualOrdersLayout())),
    DOUBLE_ONE_ONE(List.of(twoEqualOrdersLayout(), twoEqualOrdersLayout())),
    ONE_ONE_ODD_ODD(List.of(twoEqualOrdersLayout(), singleOrderLayout(), singleOrderLayout())),
    ONE_ONE_TWO_ODD(List.of(oneOneTwoLayout(), singleOrderLayout())),
    ALL_ODD(LayoutRatio::getAllOddLayouts);


    private final Function<Integer, List<Layout>> layouts;

    LayoutRatio(List<Layout> layouts) {
        this.layouts = any -> layouts;
    }

    LayoutRatio(Function<Integer, List<Layout>> layouts) {
        this.layouts = layouts;
    }


    public List<Layout> getLayouts(int size) {
        return layouts.apply(size);
    }

    private static Layout fourEqualOrdersLayout() {
        return new Layout(
                "1/4 + 1/4 + 1/4 + 1/4", 2, "without overturn");
    }

    private static Layout oneOneTwoLayout() {
        return new Layout("1/4 + 1/4 + 2/4", 2, "without overturn");
    }

    private static Layout oneToThreeOrderLayout() {
        return new Layout("1/4 + 3/4", 2, "without overturn");
    }

    private static Layout twoEqualOrdersLayout() {
        return new Layout("2/4 + 2/4", 1, "side overturn");
    }


    private static Layout singleOrderLayout() {
        return new Layout("4/4", 1, "side overturn");
    }

    private static List<Layout> getAllOddLayouts(int orderCount) {
        return IntStream.range(0, orderCount)
                .mapToObj(any -> singleOrderLayout())
                .collect(Collectors.toList());
    }

}

