//package com.example.kuviot;

public class Rectangle implements IShapeMetrics {

    double width;
    double height;

    public Rectangle(double height, double width) {
        this.width = width;
        this.height = height;
    }

    public String toString() {
        return String.format("Rectangle with height %.2f and width %.2f", height, width);
    }

    @Override
    public String name() {
        return "rectangle";
    }

    @Override
    public double area() {
        return height * width;
    }

    @Override
    public double circumference() {
        return 2*height + 2*width;
    }
}
