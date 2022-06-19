package com.optimization;

import java.util.List;

public class LayoutsForFourOrders implements Layouts {
    public LayoutsForFourOrders() {
    }

    @Override
    public List<Layout> getLayoutsForFourOrders(double split, double split2, double split3, double split4, double split5, double split6) {
        if (split == 1 && split2 == 1 && split6 == 1) {
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
    }

    @Override
    public List<Layout> getLayouts() {
        return null;
    }

    @Override
    public List<Layout> getLayouts(double split) {
        return null;
    }

    @Override
    public List<Layout> getLayouts(double split, double split2, double split3) {
        return null;
    }
}