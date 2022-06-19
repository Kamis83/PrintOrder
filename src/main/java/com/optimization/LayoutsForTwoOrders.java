package com.optimization;

import java.util.List;

public class LayoutsForTwoOrders implements Layouts {


    @Override
    public List<Layout> getLayouts(double split) {
        if (split == 1) {
            return List.of(new Layout("2/4 + 2/4", 1, "side overturn"));
        } else if (split == 1.00 / 3.00 || split == 3.00) {
            return List.of(new Layout("1/4 + 3/4", 2, "without overturn"));
        } else {
            return List.of(new Layout("4/4", 1, "side overturn"),
                    new Layout("4/4", 1, "side overturn"));
        }
    }

    @Override
    public List<Layout> getLayouts() {
        return null;
    }

    @Override
    public List<Layout> getLayouts(double split, double split2, double split3) {
        return null;
    }

    @Override
    public List<Layout> getLayoutsForFourOrders(double split, double split2, double split3, double split4, double split5, double split6) {
        return null;
    }
}