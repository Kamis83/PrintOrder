package com.optimization;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class OptimizationTest {

    private Layout singleOrderLayout() {
        return new Layout("4/4", 1, "side overturn");
    }

    private Layout twoEqualOrdersLayout() {
        return new Layout("2/4 + 2/4", 1, "side overturn");
    }

    private Layout oneOneTwoOrdersLayout() {
        return new Layout("1/4 + 1/4 + 2/4", 2, "without overturn");
    }

    private Layout oneToThreeOrdersLayout() {
        return new Layout("1/4 + 3/4", 2, "without overturn");
    }

    private Layout fourEqualOrdersLayout() {
        return new Layout("1/4 + 1/4 + 1/4 + 1/4", 2, "without overturn");
    }

    @Test
    void singleOrderOptimization() {
        List<SheetOrder> order = List.of(new SheetOrder(2000, "A", "A"));
        List<Layout> actual = new Optimization().optimize(order);
        assertThat(actual).containsExactlyInAnyOrder(singleOrderLayout());
    }

    @Test
    void twoOrdersOneToOneOptimization() {
        List<SheetOrder> order = List.of(new SheetOrder(2000, "A", "B"),
                new SheetOrder(2000, "C", "D"));
        List<Layout> actual = new Optimization().optimize(order);
        assertThat(actual).containsExactlyInAnyOrder(twoEqualOrdersLayout());
    }

    @Test
    void twoOrdersOneToThreeOptimization() {
        List<SheetOrder> order = List.of(
                new SheetOrder(2000, "A", "B"),
                new SheetOrder(6000, "C", "D"));
        List<Layout> actual = new Optimization().optimize(order);
        assertThat(actual).containsExactlyInAnyOrder(oneToThreeOrdersLayout());
    }
    @Test
    void twoOrdersOddOptimization() {
        List<SheetOrder> order = List.of(
                new SheetOrder(1000, "A", "B"),
                new SheetOrder(6000, "C", "D"));
        List<Layout> actual = new Optimization().optimize(order);
        assertThat(actual).containsExactlyInAnyOrder(singleOrderLayout(), singleOrderLayout());
    }

    @Test
    void threeEqualOrdersOptimization() {
        List<SheetOrder> order = List.of(
                new SheetOrder(2000, "A", "B"),
                new SheetOrder(2000, "C", "D"),
                new SheetOrder(2000, "E", "F"));
        List<Layout> actual = new Optimization().optimize(order);
        assertThat(actual).containsExactlyInAnyOrder(twoEqualOrdersLayout(), singleOrderLayout());
    }
    @Test
    void oneOneTwoOrdersOptimization() {
        List<SheetOrder> order = List.of(
                new SheetOrder(2000, "A", "B"),
                new SheetOrder(2000, "C", "D"),
                new SheetOrder(4000, "E", "F"));
        List<Layout> actual = new Optimization().optimize(order);
        assertThat(actual).containsExactlyInAnyOrder(oneOneTwoOrdersLayout());
    }
    @Test
    void oneOneOddOrdersOptimization() {
        List<SheetOrder> order = List.of(
                new SheetOrder(2000, "A", "B"),
                new SheetOrder(2000, "C", "D"),
                new SheetOrder(3000, "E", "F"));
        List<Layout> actual = new Optimization().optimize(order);
        assertThat(actual).containsExactlyInAnyOrder(twoEqualOrdersLayout(), singleOrderLayout());
    }
    @Test
    void threeOddsOrdersOptimization() {
        List<SheetOrder> order = List.of(
                new SheetOrder(5000, "A", "B"),
                new SheetOrder(6000, "C", "D"),
                new SheetOrder(7000, "E", "F"));
        List<Layout> actual = new Optimization().optimize(order);
        assertThat(actual).containsExactlyInAnyOrder(singleOrderLayout(), singleOrderLayout(), singleOrderLayout());
    }
    @Test
    void fourEqualOrders() {
        List<SheetOrder> order = List.of(
                new SheetOrder(2000, "A", "B"),
                new SheetOrder(2000, "C", "D"),
                new SheetOrder(2000, "E", "F"),
                new SheetOrder(2000, "G", "H"));
        List<Layout> actual = new Optimization().optimize(order);
        assertThat(actual).containsExactlyInAnyOrder(fourEqualOrdersLayout());
    }
    @Test
    void optimization8() {
        List<SheetOrder> order = List.of(
                new SheetOrder(4000, "A", "B"),
                new SheetOrder(2000, "C", "D"),
                new SheetOrder(4000, "E", "F"),
                new SheetOrder(2000, "G", "H"));
        List<Layout> actual = new Optimization().optimize(order);
        assertThat(actual).containsExactlyInAnyOrder(twoEqualOrdersLayout(), twoEqualOrdersLayout());
    }
    @Test
    void optimization9() {
        List<SheetOrder> order = List.of(
                new SheetOrder(1000, "A", "B"),
                new SheetOrder(2000, "C", "D"),
                new SheetOrder(3000, "E", "F"),
                new SheetOrder(2000, "G", "H"));
        List<Layout> actual = new Optimization().optimize(order);
        assertThat(actual).containsExactlyInAnyOrder(twoEqualOrdersLayout(), singleOrderLayout(),singleOrderLayout());
    }
    @Test
    void optimization10() {
        List<SheetOrder> order = List.of(
                new SheetOrder(2000, "A", "B"),
                new SheetOrder(2000, "C", "D"),
                new SheetOrder(4000, "E", "F"),
                new SheetOrder(2000, "G", "H"));
        List<Layout> actual = new Optimization().optimize(order);
        assertThat(actual).containsExactlyInAnyOrder(oneOneTwoOrdersLayout(), singleOrderLayout());
    }
    @Test
    void optimization11() {
        List<SheetOrder> order = List.of(
                new SheetOrder(1000, "A", "B"),
                new SheetOrder(20000, "C", "D"),
                new SheetOrder(33000, "E", "F"),
                new SheetOrder(3000, "G", "H"));

        List<Layout> actual = new Optimization().optimize(order);
        assertThat(actual).containsExactlyInAnyOrder(singleOrderLayout(),singleOrderLayout(), singleOrderLayout(), singleOrderLayout());
    }

}