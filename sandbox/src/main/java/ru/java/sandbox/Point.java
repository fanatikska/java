package ru.java.sandbox;

/**
 * Created by Studenov-DV on 13.02.2017.
 */
public class Point {
    public double x;
    public double y;


    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distance1(Point point) {

        return Math.sqrt(Math.pow((this.x - point.x), 2) + Math.pow((this.y - point.y), 2));
    }
}