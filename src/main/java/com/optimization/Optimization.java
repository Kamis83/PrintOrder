package com.optimization;

import java.util.List;

public class Optimization {

    private final LayoutsForTwoOrders layoutsForTwoOrders = new LayoutsForTwoOrders();
    private final LayoutsForThreeOrders layoutsForThreeOrders = new LayoutsForThreeOrders();
    private final LayoutsForOrder layoutsForOrder = new LayoutsForOrder();
    private final LayoutsForFourOrders layoutsForFourOrders = new LayoutsForFourOrders();

    public List<Layout> optimize(List<SheetOrder> order) {


        switch (order.size()) {

            default:
                return layoutsForOrder.getLayouts();

            case 2:
                double split = (double) order.get(0).quantityOfOrder() / (double) order.get(1).quantityOfOrder();
                return layoutsForTwoOrders.getLayouts(split);
            case 3:
                split = (double) order.get(0).quantityOfOrder() / (double) order.get(1).quantityOfOrder();
                double split2 = (double) order.get(1).quantityOfOrder() / (double) order.get(2).quantityOfOrder();
                double split3 = (double) order.get(0).quantityOfOrder() / (double) order.get(2).quantityOfOrder();

                return layoutsForThreeOrders.getLayouts(split, split2, split3);

            case 4:
                split = (double) order.get(0).quantityOfOrder() / (double) order.get(1).quantityOfOrder();
                split2 = (double) order.get(1).quantityOfOrder() / (double) order.get(2).quantityOfOrder();
                split3 = (double) order.get(0).quantityOfOrder() / (double) order.get(2).quantityOfOrder();
                double split4 = (double) order.get(0).quantityOfOrder() / (double) order.get(3).quantityOfOrder();
                double split5 = (double) order.get(1).quantityOfOrder() / (double) order.get(3).quantityOfOrder();
                double split6 = (double) order.get(2).quantityOfOrder() / (double) order.get(3).quantityOfOrder();

                return layoutsForFourOrders.getLayoutsForFourOrders(split, split2, split3, split4, split5, split6);


        }

    }
}




