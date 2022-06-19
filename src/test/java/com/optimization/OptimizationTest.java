package com.optimization;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class OptimizationTest {


    @Test
    void optimizationDefault() {
        List<SheetOrder> order = List.of(new SheetOrder(2000, "A", "A"));


        List<Layout> actual = new Optimization().optimize(order);

        assertThat(actual).containsExactlyInAnyOrder(
                new Layout("4/4", 1, "side overturn"));
    }

    @Test
    void optimization1() {
        List<SheetOrder> order = List.of(new SheetOrder(2000, "A", "B"),
                new SheetOrder(2000, "C", "D"));


        List<Layout> actual = new Optimization().optimize(order);

        assertThat(actual).containsExactlyInAnyOrder(
                new Layout("2/4 + 2/4", 1, "side overturn"));
    }

    @Test
    void optimization2() {
        List<SheetOrder> order = List.of(
                new SheetOrder(2000, "A", "B"),
                new SheetOrder(6000, "C", "D"));


        List<Layout> actual = new Optimization().optimize(order);

        assertThat(actual).containsExactlyInAnyOrder(
                new Layout("1/4 + 3/4", 2, "without overturn"));
    }

    @Test
    void optimization3() {
        List<SheetOrder> order = List.of(
                new SheetOrder(1000, "A", "B"),
                new SheetOrder(6000, "C", "D"));


        List<Layout> actual = new Optimization().optimize(order);

        assertThat(actual).containsExactlyInAnyOrder(
                new Layout("4/4", 1, "side overturn"),
                new Layout("4/4", 1, "side overturn"));
    }

    @Test
    void optimization4() {
        List<SheetOrder> order = List.of(
                new SheetOrder(2000, "A", "B"),
                new SheetOrder(2000, "C", "D"),
                new SheetOrder(2000, "E", "F"));


        List<Layout> actual = new Optimization().optimize(order);

        assertThat(actual).containsExactlyInAnyOrder(
                new Layout("2/4 + 2/4", 1, "side overturn"),
                new Layout("4/4", 1, "side overturn"));
    }

    @Test
    void optimization5() {
        List<SheetOrder> order = List.of(
                new SheetOrder(2000, "A", "B"),
                new SheetOrder(2000, "C", "D"),
                new SheetOrder(4000, "E", "F"));


        List<Layout> actual = new Optimization().optimize(order);

        assertThat(actual).containsExactlyInAnyOrder(
                new Layout("1/4 + 1/4 + 2/4", 2, "without overturn"));

    }

    @Test
    void optimization6() {
        List<SheetOrder> order = List.of(
                new SheetOrder(5000, "A", "B"),
                new SheetOrder(6000, "C", "D"),
                new SheetOrder(7000, "E", "F"));


        List<Layout> actual = new Optimization().optimize(order);

        assertThat(actual).containsExactlyInAnyOrder(
                new Layout("4/4", 1, "side overturn"),
                new Layout("4/4", 1, "side overturn"),
                new Layout("4/4", 1, "side overturn")
        );

    }

    @Test
    void optimization7() {
        List<SheetOrder> order = List.of(
                new SheetOrder(2000, "A", "B"),
                new SheetOrder(2000, "C", "D"),
                new SheetOrder(2000, "E", "F"),
                new SheetOrder(2000, "G", "H"));


        List<Layout> actual = new Optimization().optimize(order);

        assertThat(actual).containsExactlyInAnyOrder(
                new Layout("1/4 + 1/4 + 1/4 + 1/4", 2, "without overturn"));
    }

    @Test
    void optimization8() {
        List<SheetOrder> order = List.of(
                new SheetOrder(4000, "A", "B"),
                new SheetOrder(2000, "C", "D"),
                new SheetOrder(4000, "E", "F"),
                new SheetOrder(2000, "G", "H"));


        List<Layout> actual = new Optimization().optimize(order);

        assertThat(actual).containsExactlyInAnyOrder(
                new Layout("2/4 + 2/4", 1, "side overturn"),
                new Layout("2/4 + 2/4", 1, "side overturn"));
    }

    @Test
    void optimization9() {
        List<SheetOrder> order = List.of(
                new SheetOrder(1000, "A", "B"),
                new SheetOrder(2000, "C", "D"),
                new SheetOrder(3000, "E", "F"),
                new SheetOrder(2000, "G", "H"));


        List<Layout> actual = new Optimization().optimize(order);

        assertThat(actual).containsExactlyInAnyOrder(
                new Layout("2/4 + 2/4", 1, "side overturn"),
                new Layout("1/4 + 3/4", 2, "without overturn"));
    }

    @Test
    void optimization10() {
        List<SheetOrder> order = List.of(
                new SheetOrder(2000, "A", "B"),
                new SheetOrder(2000, "C", "D"),
                new SheetOrder(4000, "E", "F"),
                new SheetOrder(2000, "G", "H"));


        List<Layout> actual = new Optimization().optimize(order);

        assertThat(actual).containsExactlyInAnyOrder(
                new Layout("1/4 + 1/4 + 2/4", 2, "without overturn"),
                new Layout("4/4", 1, "side overturn"));
    }

    @Test
    void optimization11() {
        List<SheetOrder> order = List.of(
                new SheetOrder(1000, "A", "B"),
                new SheetOrder(20000, "C", "D"),
                new SheetOrder(33000, "E", "F"),
                new SheetOrder(3000, "G", "H"));


        List<Layout> actual = new Optimization().optimize(order);

        assertThat(actual).containsExactlyInAnyOrder(
                new Layout("4/4", 1, "side overturn"),
                new Layout("4/4", 1, "side overturn"),
                new Layout("4/4", 1, "side overturn"),
                new Layout("4/4", 1, "side overturn"));
    }

}