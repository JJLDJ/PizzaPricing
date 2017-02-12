package com.pizzapricing;

/**
 * Represents a single pizza. Currently assumes that all pizzas are round.
 */
final class Pizza {
    private final double pizzaDiameter;
    private final double pizzaPrice;

    /** Creates a new pizza with the specified diameter. */
    Pizza(double pizzaDiameter, double pizzaPrice) {
        this.pizzaDiameter = pizzaDiameter;
        this.pizzaPrice = pizzaPrice;
    }

    /** Returns the diameter of the pizza. */
    double getDiameter() {
        return pizzaDiameter;
    }

    /** Returns the price of the pizza. */
    double getPrice() {return pizzaPrice; }

    /** Returns the total surface area of the pizza. */
    double getArea() {return Math.pow(pizzaDiameter/2,2)*Math.PI;}

    /** Returns price per square inch of pizza. */
    double getCost() { return pizzaPrice/getArea(); }
}
