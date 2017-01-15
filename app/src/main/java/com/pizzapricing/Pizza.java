package com.pizzapricing;

/**
 * Represents a single pizza. Currently assumes that all pizzas are round.
 */
final class Pizza {
    private final double pizzaDiameter;

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
        return Math.pow(pizzaDiameter/2,2)*3.1416;
    }
}
