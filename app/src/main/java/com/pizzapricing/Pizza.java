package com.pizzapricing;

/**
 * Represents a single pizza. Currently assumes that all pizzas are round.
 */
final class Pizza {
    private double pizzaDiameter;

    /** Creates a new pizza with the specified diameter. */
    Pizza(double pizzaDiameter) {
        this.pizzaDiameter = pizzaDiameter;
    }

    /** Returns the diameter of the pizza. */
    double getDiameter() {
        return pizzaDiameter;
    }

    /** Returns the total surface area of the pizza. */
    double getArea() {
        // TODO: Implement this.
        return 0.0;
    }
}
