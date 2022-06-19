package com.optimization;

import java.util.List;

public interface Layouts {

    List<Layout> getLayouts();
    List<Layout> getLayouts(double split);
    List<Layout> getLayouts(double split, double split2, double split3);
    List<Layout> getLayoutsForFourOrders(double split, double split2, double split3, double split4, double split5, double split6);


}

