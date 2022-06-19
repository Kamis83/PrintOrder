package com.optimization;

import java.util.List;

public class Optimization {
    public List<Layout> optimize(List<SheetOrder> order) {


        switch (order.size()) {


            default:
                return List.of(new Layout("4/4", 1, "side overturn"));

            case 2:
                double split = (double) order.get(0).quantityOfOrder() / (double) order.get(1).quantityOfOrder();
                if (split == 1) {
                    return List.of(new Layout("2/4 + 2/4", 1, "side overturn"));
                } else if (split == 1.00 / 3.00 || split == 3.00) {
                    return List.of(new Layout("1/4 + 3/4", 2, "without overturn"));
                } else {
                    return List.of(new Layout("4/4", 1, "side overturn"),
                            new Layout("4/4", 1, "side overturn"));
                }
            case 3:
                split = (double) order.get(0).quantityOfOrder() / (double) order.get(1).quantityOfOrder();
                double split2 = (double) order.get(1).quantityOfOrder() / (double) order.get(2).quantityOfOrder();
                double split3 = (double) order.get(0).quantityOfOrder() / (double) order.get(2).quantityOfOrder();

                if (split == 1 && split2 != 0.5 || split2 == 1 && split != 2 || split3 == 1 && split != 0.5) {

                    return List.of(new Layout("2/4 + 2/4", 1, "side overturn"),
                            new Layout("4/4", 1, "side overturn"));

                } else if (split == 1 || split2 == 1 || split3 == 1) {
                    return List.of(new Layout("1/4 + 1/4 + 2/4", 2, "without overturn"));

                } else {
                    return List.of(new Layout("4/4", 1, "side overturn"),
                            new Layout("4/4", 1, "side overturn"),
                            new Layout("4/4", 1, "side overturn"));
                }
            case 4:
                split = (double) order.get(0).quantityOfOrder() / (double) order.get(1).quantityOfOrder();
                split2 = (double) order.get(1).quantityOfOrder() / (double) order.get(2).quantityOfOrder();
                split3 = (double) order.get(0).quantityOfOrder() / (double) order.get(2).quantityOfOrder();
                double split4 = (double) order.get(0).quantityOfOrder() / (double) order.get(3).quantityOfOrder();
                double split5 = (double) order.get(1).quantityOfOrder() / (double) order.get(3).quantityOfOrder();
                double split6 = (double) order.get(2).quantityOfOrder() / (double) order.get(3).quantityOfOrder();
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


        }

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

