package com.optimization;

import com.optimization.ratio.LayoutRatioCalculator;

import java.util.List;
import java.util.stream.Collectors;

public class Optimization {

    private final LayoutRatioCalculator layoutRatioCalculator = new LayoutRatioCalculator();

    public List<Layout> optimize(List<SheetOrder> orders) {
        LayoutRatio layoutRatio = getLayoutRatio(orders);
        return layoutRatio.getLayouts(orders.size());
    }

    private LayoutRatio getLayoutRatio(List<SheetOrder> orders) {
        return layoutRatioCalculator.getLayoutRatio(getOrderQuantities(orders));
    }


    private List<Integer> getOrderQuantities(List<SheetOrder> orders) {
        return orders.stream()
                .map(SheetOrder::quantityOfOrder)
                .collect(Collectors.toList());
    }

}




