package com.zayats;

public class Parameters {
    private final double perimeter;
    private final double square;

    public Parameters(double perimeter, double square) {
        this.perimeter = perimeter;
        this.square = square;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public double getSquare() {
        return square;
    }
}
