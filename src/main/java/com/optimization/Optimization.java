package com.optimization;

import com.optimization.ratio.LayoutRatioCalculator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Optimization {
    private final LayoutRatioCalculator layoutRatioCalculator = new LayoutRatioCalculator();

    public List<Layout> optimize(List<SheetOrder> orders) {
        switch (orders.size()) {
            case 1:
                return List.of(singleOrderLayout());
            case 2:
                return switch (getLayoutRatio(orders)) {
                    case ONE_ONE -> List.of(twoEqualOrderLayout());
                    case ONE_THREE -> List.of(oneToThreeOrdersLayout());
                    case ALL_ODD -> getAllOddLayouts(orders.size());
                    default -> throw new IllegalStateException("Unexpected value: " + getLayoutRatio(orders));
                };
            case 3:
                return switch (getLayoutRatio(orders)) {
                    case ONE_ONE_TWO -> List.of(oneOneTwoLayout());
                    case ONE_ONE_ODD -> List.of(twoEqualOrderLayout(), singleOrderLayout());
                    case ALL_ODD -> getAllOddLayouts(orders.size());
                    default -> throw new IllegalStateException("Unexpected value: " + getLayoutRatio(orders));
                };
            case 4:
                double split = (double) orders.get(0).quantityOfOrder() / (double) orders.get(1).quantityOfOrder();
                double split2 = (double) orders.get(1).quantityOfOrder() / (double) orders.get(2).quantityOfOrder();
                double split3 = (double) orders.get(0).quantityOfOrder() / (double) orders.get(2).quantityOfOrder();
                double split4 = (double) orders.get(0).quantityOfOrder() / (double) orders.get(3).quantityOfOrder();
                double split5 = (double) orders.get(1).quantityOfOrder() / (double) orders.get(3).quantityOfOrder();
                double split6 = (double) orders.get(2).quantityOfOrder() / (double) orders.get(3).quantityOfOrder();
                if (split == 1 && split2 == 1 && split3 == 1 && split4 == 1) {

                    return List.of(new Layout(
                            "1/4 + 1/4 + 1/4 + 1/4", 2, "without overturn"));
                } else if (split == 1 && split6 == 1 || split2 == 1 && split4 == 1 || split3 == 1 && split5 == 1) {
                    return List.of(new Layout("2/4 + 2/4", 1, "side overturn"),
                            new Layout("2/4 + 2/4", 1, "side overturn"));

                } else if (split == 1 && (split6 == 3.00 || split6 == 1.00 / 3.00) ||
                        split6 == 1 && (split == 3.00 || split == 1.00 / 3.00) ||
                        split2 == 1 && (split4 == 3.00 || split4 == 1.00 / 3.00) ||
                        split4 == 1 && (split2 == 3.00 || split2 == 1.00 / 3.00) ||
                        split3 == 1 && (split5 == 3.00 || split5 == 1.00 / 3.00) ||
                        split5 == 1 && (split3 == 3.00 || split3 == 1.00 / 3.00)) {
                    return List.of(new Layout("2/4 + 2/4", 1, "side overturn"),
                            new Layout("1/4 + 3/4", 2, "without overturn"));
                } else if (split == 1 && (split3 == 0.5 || split4 == 0.5) ||
                        split2 == 1 && (split == 2 || split5 == 0.5) ||
                        split3 == 1 && (split == 0.5 || split4 == 0.5) ||
                        split4 == 1 && (split == 0.5 || split3 == 0.5) ||
                        split5 == 1 && (split == 2 || split6 == 2) ||
                        split6 == 1 && (split3 == 2 || split4 == 6)) {
                    return List.of(new Layout("1/4 + 1/4 + 2/4", 2, "without overturn"),
                            new Layout("4/4", 1, "side overturn"));
                } else {
                    return List.of(new Layout("4/4", 1, "side overturn"),
                            new Layout("4/4", 1, "side overturn"),
                            new Layout("4/4", 1, "side overturn"),
                            new Layout("4/4", 1, "side overturn"));

                }

            default:
                throw new RuntimeException("Not supported!");
        }

    }

    private List<Layout> getAllOddLayouts(int orderCount) {
        return IntStream.range(0, orderCount)
                .mapToObj(any -> singleOrderLayout())
                .collect(Collectors.toList());
    }

    private Layout oneOneTwoLayout() {
        return new Layout("1/4 + 1/4 + 2/4", 2, "without overturn");
    }

    private LayoutRatio getLayoutRatio(List<SheetOrder> orders) {
        return layoutRatioCalculator.getLayoutRatio(getOrderSizes(orders));
    }

    private List<Integer> getOrderSizes(List<SheetOrder> orders) {
        return orders.stream()
                .map(SheetOrder::quantityOfOrder)
                .collect(Collectors.toList());
    }

    private Layout oneToThreeOrdersLayout() {
        return new Layout("1/4 + 3/4", 2, "without overturn");
    }

    private Layout twoEqualOrderLayout() {
        return new Layout("2/4 + 2/4", 1, "side overturn");
    }

    private Layout singleOrderLayout() {
        return new Layout("4/4", 1, "side overturn");
    }

}

//        public List<Layout> setPrintRun (List < SheetOrder > order, List < Layout > layout){
//
//            if (layout.size() < 2) {
//                int printRun = order.get(0).quantityOfOrder() / 4;
//
//
//            }
//            return List.of();
//        }
//    }

