package com.optimization;

import java.util.List;

public class LayoutsForOrder implements Layouts{
    public LayoutsForOrder() {
    }
    @Override
    public List<Layout> getLayouts() {
        return List.of(new Layout("4/4", 1, "side overturn"));
    }

    @Override
    public List<Layout> getLayouts(double split) {
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