package com.optimization;

import java.util.List;

public class LayoutsForThreeOrders implements Layouts {

    @Override
    public List<Layout> getLayouts(double split, double split2, double split3) {
        if (split == 1 || split2 == 1 || split3 == 1) {

            if (split2 == 0.5 || split == 2 || split == 0.5) {
                return List.of(new Layout("1/4 + 1/4 + 2/4", 2, "without overturn"));
            }
            return List.of(new Layout("2/4 + 2/4", 1, "side overturn"),
                    new Layout("4/4", 1, "side overturn"));

        }
        return List.of(new Layout("4/4", 1, "side overturn"),
                new Layout("4/4", 1, "side overturn"),
                new Layout("4/4", 1, "side overturn"));

    }

    @Override
    public List<Layout> getLayoutsForFourOrders(double split, double split2, double split3, double split4, double split5, double split6) {
        return null;
    }

    @Override
    public List<Layout> getLayouts() {
        return null;
    }

    @Override
    public List<Layout> getLayouts(double split) {
        return null;
    }
}
